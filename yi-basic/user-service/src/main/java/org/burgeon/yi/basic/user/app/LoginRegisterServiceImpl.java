package org.burgeon.yi.basic.user.app;

import lombok.extern.slf4j.Slf4j;
import org.burgeon.yi.basic.user.client.dto.request.LoginByMobileVerificationCodeRequest;
import org.burgeon.yi.basic.user.client.dto.request.RegisterByMobileVerificationCodeRequest;
import org.burgeon.yi.basic.user.client.service.LoginRegisterService;
import org.burgeon.yi.boot.definition.exception.BusinessException;
import org.burgeon.yi.boot.definition.exception.ParamException;
import org.springframework.stereotype.Service;

/**
 * @author Sam Lu
 * @date 2022/06/21
 */
@Slf4j
@Service
public class LoginRegisterServiceImpl implements LoginRegisterService {

    @Override
    public void loginByMobileVerificationCode(LoginByMobileVerificationCodeRequest request) throws ParamException, BusinessException {
        log.info("LoginByMobileVerificationCode => mobile: {}, verificationCode: {}", request.getMobile(), request.getVerificationCode());
    }

    @Override
    public void registerByMobileVerificationCode(RegisterByMobileVerificationCodeRequest request) throws ParamException, BusinessException {
        log.info("RegisterByMobileVerificationCode => mobile: {}, verificationCode: {}", request.getMobile(), request.getVerificationCode());
    }

}
