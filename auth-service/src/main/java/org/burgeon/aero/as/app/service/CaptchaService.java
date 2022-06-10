package org.burgeon.aero.as.app.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.burgeon.aero.as.app.model.Captcha;
import org.springframework.stereotype.Service;

/**
 * @author Sam Lu
 * @date 2021/12/9
 */
@Slf4j
@Service
public class CaptchaService {

    public void sendCaptcha(Captcha captcha) {
        String code = RandomStringUtils.randomNumeric(6);
        log.info("Send Captcha, Type: {}, Subject: {}, Code: {}", captcha.getType(),
                captcha.getSubject(), code);
    }

}
