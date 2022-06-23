package org.burgeon.yi.basic.user.client.dto.request;

import lombok.Data;
import org.burgeon.yi.basic.user.client.enums.MobileVerificationCodeTypeEnum;

/**
 * 发送手机验证码
 *
 * @author Sam Lu
 * @date 2022/06/22
 */
@Data
public class MobileVerificationCodeSendRequest {

    /**
     * 手机
     */
    private String mobile;

    /**
     * 手机验证码类型
     */
    private MobileVerificationCodeTypeEnum verificationCodeType;

}
