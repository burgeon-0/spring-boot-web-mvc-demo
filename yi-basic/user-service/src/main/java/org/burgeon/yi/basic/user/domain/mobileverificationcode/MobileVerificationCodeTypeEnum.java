package org.burgeon.yi.basic.user.domain.mobileverificationcode;

import lombok.Getter;

/**
 * 手机验证码类型
 *
 * @author Sam Lu
 * @date 2022/06/24
 */
public enum MobileVerificationCodeTypeEnum {

    /**
     * 登录
     */
    LOGIN("使用验证码登录"),
    /**
     * 注册
     */
    REGISTER("使用验证码注册");

    MobileVerificationCodeTypeEnum(String description) {
        this.description = description;
    }

    /**
     * 描述
     */
    @Getter
    private String description;

}
