package org.burgeon.yi.basic.user.client.service;

import org.burgeon.yi.basic.user.client.dto.request.LoginSendMobileCaptchaRequest;
import org.burgeon.yi.basic.user.client.dto.request.RegisterByMobileCaptchaRequest;
import org.burgeon.yi.basic.user.client.dto.request.RegisterSendMobileCaptchaRequest;

/**
 * 注册服务
 *
 * @author Sam Lu
 * @date 2022/07/02
 */
public interface RegisterService {

    /**
     * 发送注册验证码
     *
     * @param request 发送验证码请求
     */
    void sendMobileCaptcha(RegisterSendMobileCaptchaRequest request);

    /**
     * 通过手机验证码注册
     *
     * @param request 注册请求
     * @return 注册成功的跳转地址
     */
    String registerByMobileCaptcha(RegisterByMobileCaptchaRequest request);

}
