package org.burgeon.yi.mall.common.model.user;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * @author Sam Lu
 * @date 2022/2/23
 */
@Data
public class UserRequest {

    @NotBlank
    @Size(max = 20)
    private String mobile;

    @Size(max = 50)
    private String email;

    @NotBlank
    @Size(max = 30)
    private String nickname;

}
