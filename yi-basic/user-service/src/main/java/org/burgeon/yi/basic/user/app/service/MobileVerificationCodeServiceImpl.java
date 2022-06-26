package org.burgeon.yi.basic.user.app.service;

import lombok.extern.slf4j.Slf4j;
import org.burgeon.yi.basic.user.app.converter.MobileVerificationCodeConverter;
import org.burgeon.yi.basic.user.client.dto.request.MobileVerificationCodeSendRequest;
import org.burgeon.yi.basic.user.client.service.MobileVerificationCodeService;
import org.burgeon.yi.boot.definition.exception.ValidationException;
import org.springframework.stereotype.Service;

/**
 * @author Sam Lu
 * @date 2022/06/21
 */
@Slf4j
@Service
public class MobileVerificationCodeServiceImpl implements MobileVerificationCodeService {

    @Override
    public void sendMobileVerificationCode(MobileVerificationCodeSendRequest request) throws ValidationException {
        log.info("SendMobileVerificationCode => mobile: {}, type: {}", request.getMobile(), request.getType());
        MobileVerificationCodeConverter.INSTANCE.toMobileVerificationCode(request)
                .init()
                .send();
    }

}
