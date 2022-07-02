package org.burgeon.yi.basic.user.client.dto.request;

import lombok.Data;
import org.burgeon.yi.basic.user.client.constant.Constants;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * 发送注册验证码
 *
 * @author Sam Lu
 * @date 2022/07/02
 */
@Data
public class RegisterSendMobileCaptchaRequest implements Serializable {

    /**
     * 手机号
     */
    @NotBlank
    @Pattern(regexp = Constants.REG_MOBILE)
    private String mobile;

}
