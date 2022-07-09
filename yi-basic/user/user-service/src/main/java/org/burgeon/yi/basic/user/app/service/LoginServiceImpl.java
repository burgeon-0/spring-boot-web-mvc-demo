package org.burgeon.yi.basic.user.app.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.burgeon.yi.basic.user.domain.login.AggLoginLauncher;
import org.burgeon.yi.basic.user.dto.request.LoginRequest;
import org.burgeon.yi.basic.user.service.LoginService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author Sam Lu
 * @date 2022/07/02
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService {

    private final AggLoginLauncher aggLoginLauncher;

    /**
     * 登录成功的默认跳转地址
     */
    @Value("${app.config.login.defaultRedirectUrl:${server.host}/res/profile.html}")
    private String loginDefaultRedirectUrl;

    @Override
    public String login(LoginRequest request) {
        aggLoginLauncher.login(request.getUsername(), request.getPassword());
        return loginDefaultRedirectUrl;
    }

}
