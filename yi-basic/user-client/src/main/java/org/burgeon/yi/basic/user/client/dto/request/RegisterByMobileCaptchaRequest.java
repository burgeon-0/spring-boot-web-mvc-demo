package org.burgeon.yi.basic.user.client.dto.request;

import lombok.Data;
import org.burgeon.yi.basic.user.client.constant.Constants;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * 通过手机验证码注册
 *
 * @author Sam Lu
 * @date 2022/07/02
 */
@Data
public class RegisterByMobileCaptchaRequest implements Serializable {

    /**
     * 手机号
     */
    @NotBlank
    @Pattern(regexp = Constants.REG_MOBILE)
    private String mobile;

    /**
     * 手机验证码
     */
    @NotBlank
    @Pattern(regexp = Constants.REG_MOBILE_CAPTCHA)
    private String code;

}
