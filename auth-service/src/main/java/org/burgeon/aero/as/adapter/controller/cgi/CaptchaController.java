package org.burgeon.aero.as.adapter.controller.cgi;

import lombok.extern.slf4j.Slf4j;
import org.burgeon.aero.as.adapter.model.Response;
import org.burgeon.aero.as.adapter.model.SendCaptchaForm;
import org.burgeon.aero.as.app.model.Captcha;
import org.burgeon.aero.as.app.service.CaptchaService;
import org.burgeon.aero.as.infra.Constants;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Sam Lu
 * @date 2021/12/9
 */
@Slf4j
@RestController
@RequestMapping(Constants.CGI + "/captcha")
public class CaptchaController {

    @Autowired
    private CaptchaService captchaService;

    @PostMapping
    public Response sendCaptcha(@Validated @RequestBody SendCaptchaForm sendCaptchaForm) {
        Captcha captcha = new Captcha();
        BeanUtils.copyProperties(sendCaptchaForm, captcha);
        captchaService.sendCaptcha(captcha);
        return Response.ok();
    }

}
