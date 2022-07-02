package org.burgeon.yi.basic.user.domain.login.enums;

import lombok.Getter;
import org.burgeon.yi.plugin.sms.definition.MobileCaptchaType;

/**
 * 手机验证码类型
 *
 * @author Sam Lu
 * @date 2022/06/24
 */
public enum MobileCaptchaTypeEnum implements MobileCaptchaType {

    /**
     * 登录
     */
    LOGIN("LOGIN", "使用验证码登录"),
    /**
     * 注册
     */
    REGISTER("REGISTER", "使用验证码注册");

    MobileCaptchaTypeEnum(String type, String description) {
        this.type = type;
        this.description = description;
    }

    /**
     * 验证码类型
     */
    @Getter
    private String type;

    /**
     * 验证码描述
     */
    @Getter
    private String description;

}
