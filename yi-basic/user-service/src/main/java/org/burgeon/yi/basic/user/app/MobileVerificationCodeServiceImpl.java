package org.burgeon.yi.basic.user.app;

import lombok.extern.slf4j.Slf4j;
import org.burgeon.yi.basic.user.client.dto.request.MobileVerificationCodeCheckRequest;
import org.burgeon.yi.basic.user.client.dto.request.MobileVerificationCodeSendRequest;
import org.burgeon.yi.basic.user.client.service.MobileVerificationCodeService;
import org.burgeon.yi.boot.definition.exception.BusinessException;
import org.burgeon.yi.boot.definition.exception.ParamException;
import org.springframework.stereotype.Service;

/**
 * @author Sam Lu
 * @date 2022/06/21
 */
@Slf4j
@Service
public class MobileVerificationCodeServiceImpl implements MobileVerificationCodeService {

    @Override
    public void sendMobileVerificationCode(MobileVerificationCodeSendRequest request) throws ParamException, BusinessException {
        log.info("SendMobileVerificationCode => mobile: {}, verificationCodeType: {}", request.getMobile(), request.getVerificationCodeType());
        log.info("SendMobileVerificationCode => verificationCode: {}", "888888");
    }

    @Override
    public void checkMobileVerificationCode(MobileVerificationCodeCheckRequest request) throws ParamException, BusinessException {
        log.info("CheckMobileVerificationCode => mobile: {}, verificationCode: {}, verificationCodeType: {}", request.getMobile(), request.getVerificationCode(), request.getVerificationCodeType());

    }

}
