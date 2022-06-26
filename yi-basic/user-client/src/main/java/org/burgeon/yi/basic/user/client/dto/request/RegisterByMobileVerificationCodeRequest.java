package org.burgeon.yi.basic.user.client.dto.request;

import lombok.Data;
import org.burgeon.yi.basic.user.client.constant.Constants;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 * 通过手机验证码登录
 *
 * @author Sam Lu
 * @date 2022/06/21
 */
@Data
public class RegisterByMobileVerificationCodeRequest {

    /**
     * 手机
     */
    @NotBlank
    @Pattern(regexp = Constants.REG_MOBILE)
    private String mobile;

    /**
     * 验证码
     */
    @NotBlank
    @Pattern(regexp = Constants.REG_MOBILE_VERIFICATION_CODE)
    private String code;

}
