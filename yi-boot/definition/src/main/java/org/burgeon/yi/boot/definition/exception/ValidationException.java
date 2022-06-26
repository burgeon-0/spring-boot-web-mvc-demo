package org.burgeon.yi.boot.definition.exception;

import lombok.Getter;

/**
 * 校验异常
 *
 * @author Sam Lu
 * @date 2022/06/26
 */
public class ValidationException extends RuntimeException {

    /**
     * 错误码
     */
    @Getter
    private int code;

    /**
     * 错误信息
     */
    @Getter
    private String message;

    public ValidationException(ErrorEnum error) {
        this.code = error.getCode();
        this.message = error.getMessage();
    }

    public ValidationException(int code, String message) {
        this.code = code;
        this.message = message;
    }

}
