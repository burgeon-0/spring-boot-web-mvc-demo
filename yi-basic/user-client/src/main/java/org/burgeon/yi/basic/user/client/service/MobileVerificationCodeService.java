package org.burgeon.yi.basic.user.client.service;

import org.burgeon.yi.basic.user.client.dto.request.MobileVerificationCodeCheckRequest;
import org.burgeon.yi.basic.user.client.dto.request.MobileVerificationCodeSendRequest;
import org.burgeon.yi.boot.definition.exception.BusinessException;
import org.burgeon.yi.boot.definition.exception.ParamException;

/**
 * 手机验证码服务
 *
 * @author Sam Lu
 * @date 2022/06/21
 */
public interface MobileVerificationCodeService {

    /**
     * 发送手机验证码
     *
     * @param request 发送请求
     * @throws ParamException 参数异常
     * @throws BusinessException 业务异常
     */
    void sendMobileVerificationCode(MobileVerificationCodeSendRequest request) throws ParamException, BusinessException;

    /**
     * 验证手机验证码
     *
     * @param request 校验请求
     * @throws ParamException 参数异常
     * @throws BusinessException 业务异常
     */
    void checkMobileVerificationCode(MobileVerificationCodeCheckRequest request) throws ParamException, BusinessException;

}
