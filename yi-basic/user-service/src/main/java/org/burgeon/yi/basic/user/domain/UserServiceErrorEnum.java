package org.burgeon.yi.basic.user.domain;

import lombok.Getter;
import org.burgeon.yi.boot.definition.exception.ErrorEnum;

/**
 * 用户服务异常枚举
 * <p>
 * 错误码格式：XXYYZZZ，XX - 系统编号，YY - 领域编号，ZZZ - 错误编号，如：0101001 - 用户服务的登录业务中，手机验证码不正确。
 * 用户服务的系统编号为：01。
 * YYZZZ中，00开头的错误码表示通用错误码，01~99开头的错误码表示业务错误码。
 *
 * @author Sam Lu
 * @date 2022/06/26
 */
public enum UserServiceErrorEnum implements ErrorEnum {

    /**
     * ###########################
     * 登录领域编号：01
     * ###########################
     */
    /**
     * 手机验证码不正确
     */
    MOBILE_CAPTCHA_INVALID("0101001", "MobileCaptcha invalid.");

    UserServiceErrorEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * 错误码
     */
    @Getter
    private String code;

    /**
     * 错误信息
     */
    @Getter
    private String message;

}
