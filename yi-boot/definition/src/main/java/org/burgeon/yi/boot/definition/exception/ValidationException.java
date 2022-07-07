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
    private final String code;

    /**
     * 错误信息
     */
    @Getter
    private final String message;

    public ValidationException(ErrorEnum error) {
        this.code = error.getCode();
        this.message = error.getMessage();
    }

    public ValidationException(String code, String message) {
        this.code = code;
        this.message = message;
    }

}
