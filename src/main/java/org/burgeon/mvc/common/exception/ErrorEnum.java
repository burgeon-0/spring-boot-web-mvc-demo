package org.burgeon.mvc.common.exception;

import lombok.Getter;

/**
 * @author Sam Lu
 * @date 2022/2/23
 */
@Getter
public enum ErrorEnum {

    /**
     * 参数非法
     */
    PARAM_INVALID(40001000, "Param invalid."),
    /**
     * 重复的手机
     */
    DUPLICATE_MOBILE(40001001, "Duplicate mobile."),
    /**
     * 重复的邮箱
     */
    DUPLICATE_EMAIL(40001002, "Duplicate email."),
    /**
     * 用户不存在
     */
    USER_NOT_FOUND(40001003, "User not found."),

    /**
     * 服务器异常
     */
    INTERNAL_SERVER_ERROR(50001000, "Internal server error.");

    ErrorEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    private int code;
    private String message;

}
