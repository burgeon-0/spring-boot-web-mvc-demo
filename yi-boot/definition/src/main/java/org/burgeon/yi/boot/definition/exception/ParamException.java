package org.burgeon.yi.boot.definition.exception;

import lombok.Getter;

/**
 * 参数异常
 *
 * @author Sam Lu
 * @date 2022/06/21
 */
public class ParamException extends RuntimeException {

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

    public ParamException(ErrorEnum error) {
        this.code = error.getCode();
        this.message = error.getMessage();
    }

    public ParamException(int code, String message) {
        this.code = code;
        this.message = message;
    }

}
