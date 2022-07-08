package org.burgeon.yi.basic.user.client.dto.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * 登录请求
 *
 * @author Sam Lu
 * @date 2022/07/02
 */
@Data
public class LoginRequest implements Serializable {

    /**
     * 账号
     */
    @NotBlank
    private String username;

    /**
     * 密码
     */
    @NotBlank
    private String password;

}
