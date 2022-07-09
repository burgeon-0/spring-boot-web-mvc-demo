package org.burgeon.yi.basic.user.domain.login;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.burgeon.yi.basic.user.domain.UserServiceErrorEnum;
import org.burgeon.yi.boot.common.exception.AssertX;
import org.springframework.stereotype.Component;

/**
 * 登录器
 *
 * @author Sam Lu
 * @date 2022/07/01
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class AggLoginLauncher {

    /**
     * 通过账号密码进行登录
     *
     * @param username 账号
     * @param password 密码
     */
    public void login(String username, String password) {
        log.info("User[{}] login.", username);
        AssertX.isTrue("admin".equals(username), UserServiceErrorEnum.USERNAME_OR_PASSWORD_INVALID);
    }

}
