package org.burgeon.yi.basic.user.domain.mobileverificationcode.gateway;

import org.burgeon.yi.basic.user.domain.mobileverificationcode.MobileVerificationCode;

/**
 * 手机验证码网关
 *
 * @author Sam Lu
 * @date 2022/06/25
 */
public interface MobileVerificationCodeGateway {

    /**
     * 初始化手机验证码
     *
     * @param mobileVerificationCode 手机验证码
     * @return 手机验证码
     */
    MobileVerificationCode init(MobileVerificationCode mobileVerificationCode);

    /**
     * 发送手机验证码
     *
     * @param mobileVerificationCode 手机验证码
     * @return 手机验证码
     */
    MobileVerificationCode send(MobileVerificationCode mobileVerificationCode);

    /**
     * 校验手机验证码
     *
     * @param mobileVerificationCode 手机验证码
     * @return 手机验证码
     */
    MobileVerificationCode check(MobileVerificationCode mobileVerificationCode);

}
