package org.burgeon.yi.basic.user.client.service;

import org.burgeon.yi.basic.user.client.dto.request.LoginByMobileVerificationCodeRequest;
import org.burgeon.yi.basic.user.client.dto.request.RegisterByMobileVerificationCodeRequest;
import org.burgeon.yi.boot.definition.exception.BusinessException;
import org.burgeon.yi.boot.definition.exception.ParamException;

/**
 * 登录服务
 *
 * @author Sam Lu
 * @date 2022/06/21
 */
public interface LoginService {

    /**
     * 通过手机验证码登录
     *
     * @param request 登录请求
     * @param request
     * @return 登录结果
     * @throws ParamException 参数异常
     * @throws BusinessException 业务异常
     */
    void loginByMobileVerificationCode(LoginByMobileVerificationCodeRequest request) throws ParamException, BusinessException;

    /**
     * 通过手机验证码注册
     *
     * @param request 注册请求
     * @return 注册结果
     * @throws ParamException 参数异常
     * @throws BusinessException 业务异常
     */
    void registerByMobileVerificationCode(RegisterByMobileVerificationCodeRequest request) throws ParamException, BusinessException;

}
