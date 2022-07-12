package org.bg181.yi.basic.user.service;

import org.bg181.yi.basic.user.dto.request.LoginRequest;

/**
 * 登录服务
 *
 * @author Sam Lu
 * @date 2022/07/02
 */
public interface LoginService {

    /**
     * 通过账号密码进行登录
     *
     * @param request 登录请求
     * @return 登录成功的跳转地址
     */
    String login(LoginRequest request);

}
