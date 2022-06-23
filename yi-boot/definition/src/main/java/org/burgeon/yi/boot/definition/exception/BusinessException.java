package org.burgeon.yi.boot.definition.exception;

import lombok.Getter;

/**
 * 业务异常
 *
 * @author Sam Lu
 * @date 2022/06/21
 */
public class BusinessException extends RuntimeException {

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

    public BusinessException(ErrorEnum error) {
        this.code = error.getCode();
        this.message = error.getMessage();
    }

    public BusinessException(int code, String message) {
        this.code = code;
        this.message = message;
    }

}
