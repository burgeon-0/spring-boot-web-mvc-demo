package org.burgeon.yi.basic.user.adapter.cgi;

import lombok.RequiredArgsConstructor;
import org.burgeon.yi.basic.user.client.dto.request.RegisterByMobileCaptchaRequest;
import org.burgeon.yi.basic.user.client.dto.request.RegisterSendMobileCaptchaRequest;
import org.burgeon.yi.basic.user.client.service.RegisterService;
import org.burgeon.yi.boot.definition.rest.Response;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 注册接口
 *
 * @author Sam Lu
 * @date 2022/07/02
 */
@RestController
@RequiredArgsConstructor
public class RegisterController {

    private final RegisterService registerService;

    /**
     * 发送注册验证码
     *
     * @param request 发送验证码请求
     * @return 发送结果
     */
    @PostMapping("/cgi/register/actions/send-mobile-captcha")
    public Response sendMobileCaptcha(@Validated @RequestBody RegisterSendMobileCaptchaRequest request) {
        registerService.sendMobileCaptcha(request);
        return Response.success();
    }

    /**
     * 通过手机验证码注册
     *
     * @param request 注册请求
     * @return 注册成功的跳转地址
     */
    @PostMapping("/cgi/register/mobile-captcha")
    public Response<String> registerWithMobileCaptcha(@Validated @RequestBody RegisterByMobileCaptchaRequest request) {
        String url = registerService.registerWithMobileCaptcha(request);
        return Response.success(url);
    }

}
