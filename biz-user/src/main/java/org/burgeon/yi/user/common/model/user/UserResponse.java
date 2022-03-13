package org.burgeon.yi.user.common.model.user;

import lombok.Data;

/**
 * @author Sam Lu
 * @date 2022/2/23
 */
@Data
public class UserResponse {

    private Long id;

    private String mobile;

    private String email;

    private String nickname;

}
