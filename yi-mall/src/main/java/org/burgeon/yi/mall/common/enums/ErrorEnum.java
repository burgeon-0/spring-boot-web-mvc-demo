package org.burgeon.yi.mall.common.enums;

import lombok.Getter;
import org.burgeon.yi.rest.exception.IError;

/**
 * @author Sam Lu
 * @date 2022/2/23
 */
@Getter
public enum ErrorEnum implements IError {

    /**
     * 参数非法
     */
    PARAM_INVALID(4001000, "Param invalid."),
    /**
     * 重复的手机
     */
    DUPLICATE_MOBILE(4001001, "Duplicate mobile."),
    /**
     * 重复的邮箱
     */
    DUPLICATE_EMAIL(4001002, "Duplicate email."),
    /**
     * 用户不存在
     */
    USER_NOT_FOUND(4001003, "User not found."),

    /**
     * 服务器异常
     */
    INTERNAL_SERVER_ERROR(5001000, "Internal server error.");

    ErrorEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    private int code;
    private String message;

}
