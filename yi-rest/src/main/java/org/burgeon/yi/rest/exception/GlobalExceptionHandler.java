package org.burgeon.yi.rest.exception;

import org.burgeon.yi.rest.model.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.multipart.MultipartException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author Sam Lu
 * @date 2021/6/2
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    private static final String JSON_PARSE_ERROR_CCI = "Cannot construct instance";
    private static final String JSON_PARSE_ERROR_CDV = "Cannot deserialize value";
    private static final String JSON_PARSE_ERROR_UC = "Unexpected character";
    private static final String SPLIT1 = ": ";
    private static final String SPLIT2 = "; ";

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public Response handleHttpMessageNotReadableException(HttpMessageNotReadableException e,
                                                          HttpServletRequest request) {
        String uri = String.format("%s %s", request.getMethod(), request.getRequestURI());
        log.warn("[Exception] [{}], Http Message Not Readable Exception -> {}: {}",
                uri, e.getClass().getName(), e.getMessage());

        // eg: JSON parse error: Unexpected character (':' (code 46)): was expecting comma to separate Object entries;
        String message = e.getMessage();
        if (message.contains(SPLIT1)) {
            String msg1 = message.substring(0, message.indexOf(SPLIT1));
            String msg2 = message.substring(message.indexOf(SPLIT1) + 2);
            if (msg2.startsWith(JSON_PARSE_ERROR_CCI)) {
                message = msg1 + SPLIT1 + JSON_PARSE_ERROR_CCI;
            } else if (msg2.startsWith(JSON_PARSE_ERROR_CDV)) {
                message = msg1 + SPLIT1 + JSON_PARSE_ERROR_CDV;
            } else {
                int start = 0;
                if (msg2.startsWith(JSON_PARSE_ERROR_UC)) {
                    // eg: Unexpected character (':' (code 46)): was expecting comma to separate Object entries;
                    start = msg2.indexOf("' (code ");
                }
                int index1 = msg2.indexOf(SPLIT1, start);
                int index2 = msg2.indexOf(SPLIT2, start);
                if (index1 > -1 && index2 > -1) {
                    msg2 = msg2.substring(0, Math.min(index1, index2));
                } else if (index1 > -1 || index2 > -1) {
                    msg2 = msg2.substring(0, Math.max(index1, index2));
                } else {
                    msg2 = "";
                }
                message = msg2.length() > 0 ? msg1 + SPLIT1 + msg2 : msg1;
            }
        }
        return new Response(HttpStatus.BAD_REQUEST.value(), message);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public Response handleMethodArgumentNotValidException(MethodArgumentNotValidException e,
                                                          HttpServletRequest request) {
        String uri = String.format("%s %s", request.getMethod(), request.getRequestURI());
        log.warn("[Exception] [{}], Method Argument Not Valid Exception -> {}: {}",
                uri, e.getClass().getName(), e.getMessage());

        String message = getErrorMessage(uri, e.getAllErrors());
        return new Response(HttpStatus.BAD_REQUEST.value(), message);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public Response handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e,
                                                              HttpServletRequest request) {
        String uri = String.format("%s %s", request.getMethod(), request.getRequestURI());
        log.warn("[Exception] [{}], Method Argument Not Valid Exception -> {}: {}",
                uri, e.getClass().getName(), e.getMessage());

        return new Response(HttpStatus.BAD_REQUEST.value(), e.getMessage());
    }

    @ExceptionHandler(BindException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public Response handleBindException(BindException e, HttpServletRequest request) {
        String uri = String.format("%s %s", request.getMethod(), request.getRequestURI());
        log.warn("[Exception] [{}], Bind Exception -> {}: {}", uri, e.getClass().getName(), e.getMessage());

        String message = getErrorMessage(uri, e.getAllErrors());
        return new Response(HttpStatus.BAD_REQUEST.value(), message);
    }

    private String getErrorMessage(String uri, List<ObjectError> errors) {
        StringBuilder buf = new StringBuilder();
        for (ObjectError error : errors) {
            if (error instanceof FieldError) {
                String fieldName = ((FieldError) error).getField();
                buf.append("[").append(fieldName).append("] ");
                buf.append(error.getDefaultMessage()).append(SPLIT2);
            } else {
                log.warn("[Exception] [{}], Unexpected Error: {}", uri, error.toString());
            }
        }
        String message = buf.substring(0, buf.length() - 2);
        return message;
    }

    @ExceptionHandler(MultipartException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public Response handleMultipartException(MultipartException e, HttpServletRequest request) {
        String uri = String.format("%s %s", request.getMethod(), request.getRequestURI());
        log.warn("[Exception] [{}], Multipart Exception -> {}: {}", uri, e.getClass().getName(), e.getMessage());

        String message = e.getMessage();
        if (message.contains(SPLIT2)) {
            message = message.substring(0, message.indexOf(SPLIT2));
        }
        return new Response(HttpStatus.BAD_REQUEST.value(), message);
    }

    @ExceptionHandler(ServletException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public Response handleServletException(ServletException e, HttpServletRequest request) {
        String uri = String.format("%s %s", request.getMethod(), request.getRequestURI());
        log.warn("[Exception] [{}], Servlet Exception -> {}: {}", uri, e.getClass().getName(), e.getMessage());

        return new Response(HttpStatus.BAD_REQUEST.value(), e.getMessage());
    }

    @ExceptionHandler(ValidateException.class)
    public ResponseEntity<Response> handleBaseException(ValidateException e) {
        IError error = e.getError();
        Response response = new Response(error.getCode(), e.getMessage());
        return new ResponseEntity(response, HttpStatus.valueOf(error.getCode() / 100000));
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public Response handleRuntimeException(RuntimeException e, HttpServletRequest request) {
        String uri = String.format("%s %s", request.getMethod(), request.getRequestURI());
        log.error("[Exception] [{}], Internal Server Error", uri, e);

        return new Response(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
    }

}
