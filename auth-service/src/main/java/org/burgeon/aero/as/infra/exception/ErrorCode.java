package org.burgeon.aero.as.infra.exception;

import org.springframework.http.HttpStatus;

/**
 * @author Sam Lu
 * @date 2021/11/30
 */
public enum ErrorCode {

    /**
     * Param Invalid
     */
    PARAM_INVALID(HttpStatus.BAD_REQUEST, 4001000, "Param Invalid"),
    /**
     * Username Or Password Error
     */
    USERNAME_OR_PASSWORD_ERROR(HttpStatus.UNAUTHORIZED, 4011001, "Username Or Password Error"),
    /**
     * Internal Server Error
     */
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, 5001000, "Internal Server Error");

    ErrorCode(HttpStatus status, int code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }

    private HttpStatus status;
    private int code;
    private String message;

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
