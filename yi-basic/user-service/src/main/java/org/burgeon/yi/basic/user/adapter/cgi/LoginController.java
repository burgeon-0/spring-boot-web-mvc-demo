package org.burgeon.yi.basic.user.adapter.cgi;

import lombok.RequiredArgsConstructor;
import org.burgeon.yi.basic.user.client.dto.request.LoginByMobileCaptchaRequest;
import org.burgeon.yi.basic.user.client.dto.request.LoginSendMobileCaptchaRequest;
import org.burgeon.yi.basic.user.client.service.LoginService;
import org.burgeon.yi.boot.definition.rest.Response;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 登录接口
 *
 * @author Sam Lu
 * @date 2022/07/02
 */
@RestController
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    /**
     * 发送登录验证码
     *
     * @param request 发送验证码请求
     * @return 发送结果
     */
    @PostMapping("/cgi/login/actions/send-mobile-captcha")
    public Response sendMobileCaptcha(@Validated @RequestBody LoginSendMobileCaptchaRequest request) {
        loginService.sendMobileCaptcha(request);
        return Response.success();
    }

    /**
     * 通过手机验证码登录
     *
     * @param request 登录请求
     * @return 登录成功的跳转地址
     */
    @PostMapping("/cgi/login/mobile")
    public Response<String> loginByMobileCaptcha(@Validated @RequestBody LoginByMobileCaptchaRequest request) {
        String url = loginService.loginByMobileCaptcha(request);
        return Response.success(url);
    }

}
