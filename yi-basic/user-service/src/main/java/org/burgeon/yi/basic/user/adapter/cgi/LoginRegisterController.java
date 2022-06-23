package org.burgeon.yi.basic.user.adapter.cgi;

import lombok.RequiredArgsConstructor;
import org.burgeon.yi.basic.user.client.dto.request.LoginByMobileVerificationCodeRequest;
import org.burgeon.yi.basic.user.client.dto.request.RegisterByMobileVerificationCodeRequest;
import org.burgeon.yi.basic.user.client.service.LoginRegisterService;
import org.burgeon.yi.boot.definition.web.Result;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 登录-注册接口
 *
 * @author Sam Lu
 * @date 2022/06/21
 */
@RestController
@RequiredArgsConstructor
public class LoginRegisterController {

    private final LoginRegisterService loginRegisterService;

    /**
     * 通过手机验证码登录
     *
     * @param request 登录请求
     * @return 登录结果
     */
    @PostMapping("/cgi/login/mobile")
    public Result loginByMobileVerificationCode(@Validated @RequestBody LoginByMobileVerificationCodeRequest request) {
        loginRegisterService.loginByMobileVerificationCode(request);
        return Result.success();
    }

    /**
     * 通过手机验证码注册
     *
     * @param request 注册请求
     * @return 注册结果
     */
    @PostMapping("/cgi/register/mobile")
    public Result registerByMobileVerificationCode(@Validated @RequestBody RegisterByMobileVerificationCodeRequest request) {
        loginRegisterService.registerByMobileVerificationCode(request);
        return Result.success();
    }

}
