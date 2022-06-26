package org.burgeon.yi.basic.user.app.service;

import cn.hutool.core.bean.BeanUtil;
import lombok.extern.slf4j.Slf4j;
import org.burgeon.yi.basic.user.client.dto.request.LoginByMobileVerificationCodeRequest;
import org.burgeon.yi.basic.user.client.dto.request.RegisterByMobileVerificationCodeRequest;
import org.burgeon.yi.basic.user.client.service.LoginRegisterService;
import org.burgeon.yi.basic.user.domain.mobileverificationcode.MobileVerificationCode;
import org.burgeon.yi.basic.user.domain.mobileverificationcode.MobileVerificationCodeTypeEnum;
import org.burgeon.yi.boot.definition.exception.ValidationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author Sam Lu
 * @date 2022/06/21
 */
@Slf4j
@Service
public class LoginRegisterServiceImpl implements LoginRegisterService {

    /**
     * 登录成功的默认跳转地址
     */
    @Value("${app.config.login.defaultRedirectUrl:${server.host}/res/profile.html}")
    private String loginDefaultRedirectUrl;
    /**
     * 注册成功的默认跳转地址
     */
    @Value("${app.config.register.defaultRedirectUrl:${server.host}/res/profile.html}")
    private String registerDefaultRedirectUrl;

    @Override
    public String loginByMobileVerificationCode(LoginByMobileVerificationCodeRequest request) throws ValidationException {
        log.info("LoginByMobileVerificationCode => mobile: {}, code: {}", request.getMobile(), request.getCode());
        MobileVerificationCode mobileVerificationCode = BeanUtil.copyProperties(request, MobileVerificationCode.class);
        mobileVerificationCode.setType(MobileVerificationCodeTypeEnum.LOGIN)
                .check();
        return loginDefaultRedirectUrl;
    }

    @Override
    public String registerByMobileVerificationCode(RegisterByMobileVerificationCodeRequest request) throws ValidationException {
        log.info("RegisterByMobileVerificationCode => mobile: {}, code: {}", request.getMobile(), request.getCode());
        MobileVerificationCode mobileVerificationCode = BeanUtil.copyProperties(request, MobileVerificationCode.class);
        mobileVerificationCode.setType(MobileVerificationCodeTypeEnum.REGISTER)
                .check();
        return registerDefaultRedirectUrl;
    }

}
