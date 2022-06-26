package org.burgeon.yi.basic.user.client.service;

import org.burgeon.yi.basic.user.client.dto.request.LoginByMobileVerificationCodeRequest;
import org.burgeon.yi.basic.user.client.dto.request.RegisterByMobileVerificationCodeRequest;
import org.burgeon.yi.boot.definition.exception.ValidationException;

/**
 * 登录-注册服务
 *
 * @author Sam Lu
 * @date 2022/06/21
 */
public interface LoginRegisterService {

    /**
     * 通过手机验证码登录
     *
     * @param request 登录请求
     * @param request
     * @return 登录结果
     * @throws ValidationException 校验异常
     */
    void loginByMobileVerificationCode(LoginByMobileVerificationCodeRequest request) throws ValidationException;

    /**
     * 通过手机验证码注册
     *
     * @param request 注册请求
     * @return 注册结果
     * @throws ValidationException 校验异常
     */
    void registerByMobileVerificationCode(RegisterByMobileVerificationCodeRequest request) throws ValidationException;

}
