package org.burgeon.yi.basic.user.client.service;

import org.burgeon.yi.basic.user.client.dto.request.MobileVerificationCodeCheckRequest;
import org.burgeon.yi.basic.user.client.dto.response.MobileVerificationCodeResponse;
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
     * 获取手机验证码
     *
     * @param mobile 手机
     * @param verificationCodeType 验证码类型
     * @return 手机验证码返回信息
     * @throws ParamException 参数异常
     * @throws BusinessException 业务异常
     */
    MobileVerificationCodeResponse getMobileVerificationCode(String mobile, String verificationCodeType) throws ParamException, BusinessException;

    /**
     * 验证手机验证码
     *
     * @param request 校验请求
     * @throws ParamException 参数异常
     * @throws BusinessException 业务异常
     */
    void checkMobileVerificationCode(MobileVerificationCodeCheckRequest request) throws ParamException, BusinessException;

}
