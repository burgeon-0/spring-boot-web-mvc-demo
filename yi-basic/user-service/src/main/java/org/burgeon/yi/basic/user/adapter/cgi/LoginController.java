package org.burgeon.yi.basic.user.adapter.cgi;

import lombok.RequiredArgsConstructor;
import org.burgeon.yi.basic.user.client.dto.request.LoginRequest;
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
     * 通过账号密码进行登录
     *
     * @param request 登录请求
     * @return 登录成功的跳转地址
     */
    @PostMapping("/cgi/login")
    public Response<String> login(@Validated @RequestBody LoginRequest request) {
        String url = loginService.login(request);
        return Response.success(url);
    }

}
