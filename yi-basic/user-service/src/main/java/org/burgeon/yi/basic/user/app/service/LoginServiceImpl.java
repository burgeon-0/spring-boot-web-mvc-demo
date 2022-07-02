package org.burgeon.yi.basic.user.app.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.burgeon.yi.basic.user.client.service.LoginService;
import org.burgeon.yi.basic.user.domain.login.AggLoginLauncher;
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
    public void sendMobileCaptcha(String mobile) {
        aggLoginLauncher.sendMobileCaptcha(mobile);
    }

    @Override
    public String loginByMobileCaptcha(String mobile, String code) {
        aggLoginLauncher.loginByMobileCaptcha(mobile, code);
        return loginDefaultRedirectUrl;
    }

}
