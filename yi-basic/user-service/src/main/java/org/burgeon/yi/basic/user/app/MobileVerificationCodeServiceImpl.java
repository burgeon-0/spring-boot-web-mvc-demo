package org.burgeon.yi.basic.user.app;

import lombok.extern.slf4j.Slf4j;
import org.burgeon.yi.basic.user.client.dto.request.MobileVerificationCodeCheckRequest;
import org.burgeon.yi.basic.user.client.dto.response.MobileVerificationCodeResponse;
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
    public MobileVerificationCodeResponse getMobileVerificationCode(String mobile, String verificationCodeType) throws ParamException, BusinessException {
        log.info("mobile: {}, verificationCodeType: {}", mobile, verificationCodeType);
        return null;
    }

    @Override
    public void checkMobileVerificationCode(MobileVerificationCodeCheckRequest request) throws ParamException, BusinessException {

    }

}
