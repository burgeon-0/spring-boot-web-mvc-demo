package org.burgeon.yi.basic.user.domain.login;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.burgeon.yi.basic.user.domain.UserServiceErrorEnum;
import org.burgeon.yi.basic.user.domain.login.enums.MobileCaptchaTypeEnum;
import org.burgeon.yi.boot.common.exception.AssertX;
import org.burgeon.yi.adapter.sms.adapter.MobileCaptchaAdapter;
import org.springframework.stereotype.Component;

/**
 * 登录器
 *
 * @author Sam Lu
 * @date 2022/07/01
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class AggLoginLauncher {

    private final MobileCaptchaAdapter mobileCaptchaAdapter;

    /**
     * 发送登录验证码
     *
     * @param mobile 手机号
     */
    public void sendMobileCaptcha(String mobile) {
        mobileCaptchaAdapter.sendMobileCaptcha(mobile, MobileCaptchaTypeEnum.LOGIN);
    }

    /**
     * 通过手机验证码登录
     *
     * @param mobile 手机号
     * @param code 手机验证码
     */
    public void loginWithMobileCaptcha(String mobile, String code) {
        boolean valid = mobileCaptchaAdapter.checkMobileCaptcha(mobile, MobileCaptchaTypeEnum.LOGIN, code);
        AssertX.isTrue(valid, UserServiceErrorEnum.MOBILE_CAPTCHA_INVALID);
    }

}
