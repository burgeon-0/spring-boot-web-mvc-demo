package org.burgeon.yi.basic.user.client.dto.response;

import lombok.Data;

/**
 * 手机验证码返回信息
 *
 * @author Sam Lu
 * @date 2022/06/21
 */
@Data
public class MobileVerificationCodeResponse {

    /**
     * 手机
     */
    private String mobile;

    /**
     * 验证码
     */
    private String verificationCode;

}
