package org.burgeon.yi.basic.user.client.dto.request;

import org.burgeon.yi.basic.user.client.enums.MobileVerificationCodeTypeEnum;

/**
 * 验证手机验证码
 *
 * @author Sam Lu
 * @date 2022/06/21
 */
public class MobileVerificationCodeCheckRequest {

    /**
     * 手机
     */
    private String mobile;

    /**
     * 验证码
     */
    private String verificationCode;

    /**
     * 手机验证码类型
     */
    private MobileVerificationCodeTypeEnum verificationCodeType;

}
