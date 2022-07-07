package org.burgeon.yi.boot.rest.exception;

import lombok.extern.slf4j.Slf4j;
import org.burgeon.yi.boot.definition.exception.ValidationException;
import org.burgeon.yi.boot.definition.rest.Response;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Sam Lu
 * @date 2022/06/26
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ValidationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public Response<Void> handleValidationException(ValidationException ex, HttpServletRequest request) {
        Response<Void> response = Response.failure(HttpStatus.BAD_REQUEST.value(), ex);
        logException(request, response);
        return response;
    }

    private void logException(HttpServletRequest request, Response<Void> response) {
        log.warn("[Exception] [{} {}] => response: {}", request.getMethod(), request.getRequestURI(), response);
    }

}
