package org.burgeon.yi.basic.user.client.dto.request;

import lombok.Data;
import org.burgeon.yi.basic.user.client.constant.UserClientConstants;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * 发送登录验证码
 *
 * @author Sam Lu
 * @date 2022/07/02
 */
@Data
public class LoginSendMobileCaptchaRequest implements Serializable {

    /**
     * 手机号
     */
    @NotBlank
    @Pattern(regexp = UserClientConstants.REG_MOBILE)
    private String mobile;

}
