package org.burgeon.yi.basic.user.client.service;

import org.burgeon.yi.basic.user.client.dto.request.MobileVerificationCodeSendRequest;
import org.burgeon.yi.boot.definition.exception.ValidationException;

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
     * @throws ValidationException 校验异常
     */
    void sendMobileVerificationCode(MobileVerificationCodeSendRequest request) throws ValidationException;

}
