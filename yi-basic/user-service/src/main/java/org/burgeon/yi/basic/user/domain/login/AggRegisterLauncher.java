package org.burgeon.yi.basic.user.domain.login;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.burgeon.yi.basic.user.domain.UserServiceErrorEnum;
import org.burgeon.yi.basic.user.domain.login.enums.MobileCaptchaTypeEnum;
import org.burgeon.yi.boot.common.exception.AssertX;
import org.burgeon.yi.adapter.sms.adapter.MobileCaptchaAdapter;
import org.springframework.stereotype.Component;

/**
 * 注册器
 *
 * @author Sam Lu
 * @date 2022/07/01
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class AggRegisterLauncher {

    private final MobileCaptchaAdapter mobileCaptchaAdapter;

    /**
     * 发送注册验证码
     *
     * @param mobile 手机号
     */
    public void sendMobileCaptcha(String mobile) {
        mobileCaptchaAdapter.sendMobileCaptcha(mobile, MobileCaptchaTypeEnum.REGISTER);
    }

    /**
     * 通过手机验证码注册
     *
     * @param mobile 手机号
     * @param code 手机验证码
     */
    public void registerByMobileCaptcha(String mobile, String code) {
        boolean valid = mobileCaptchaAdapter.checkMobileCaptcha(mobile, MobileCaptchaTypeEnum.REGISTER, code);
        AssertX.isTrue(valid, UserServiceErrorEnum.MOBILE_CAPTCHA_INVALID);
    }

}
