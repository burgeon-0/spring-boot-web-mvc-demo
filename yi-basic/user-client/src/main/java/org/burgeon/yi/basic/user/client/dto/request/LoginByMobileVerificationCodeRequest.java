package org.burgeon.yi.basic.user.client.dto.request;

import lombok.Data;

/**
 * 通过手机验证码登录
 *
 * @author Sam Lu
 * @date 2022/06/21
 */
@Data
public class LoginByMobileVerificationCodeRequest {

    /**
     * 手机
     */
    private String mobile;

    /**
     * 验证码
     */
    private String verificationCode;

}
