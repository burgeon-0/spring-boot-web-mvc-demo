package org.burgeon.yi.basic.user.client.service;

import org.burgeon.yi.basic.user.client.dto.request.LoginByMobileCaptchaRequest;
import org.burgeon.yi.basic.user.client.dto.request.LoginSendMobileCaptchaRequest;

/**
 * 登录服务
 *
 * @author Sam Lu
 * @date 2022/07/02
 */
public interface LoginService {

    /**
     * 发送登录验证码
     *
     * @param request 发送验证码请求
     */
    void sendMobileCaptcha(LoginSendMobileCaptchaRequest request);

    /**
     * 通过手机验证码登录
     *
     * @param request 登录请求
     * @return 登录成功的跳转地址
     */
    String loginByMobileCaptcha(LoginByMobileCaptchaRequest request);

}
