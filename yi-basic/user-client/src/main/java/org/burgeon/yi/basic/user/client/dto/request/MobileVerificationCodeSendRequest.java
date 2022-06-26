package org.burgeon.yi.basic.user.client.dto.request;

import lombok.Data;
import org.burgeon.yi.basic.user.client.constant.Constants;
import org.burgeon.yi.basic.user.client.enums.MobileVerificationCodeTypeEnum;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

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
    @NotBlank
    @Pattern(regexp = Constants.REG_MOBILE)
    private String mobile;

    /**
     * 验证码类型
     */
    @NotNull
    private MobileVerificationCodeTypeEnum type;

}
