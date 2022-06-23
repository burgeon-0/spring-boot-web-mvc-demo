package org.burgeon.yi.basic.user.adapter.cgi;

import lombok.RequiredArgsConstructor;
import org.burgeon.yi.basic.user.client.dto.request.MobileVerificationCodeSendRequest;
import org.burgeon.yi.basic.user.client.service.MobileVerificationCodeService;
import org.burgeon.yi.boot.definition.web.Result;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 手机验证码接口
 *
 * @author Sam Lu
 * @date 2022/06/21
 */
@RestController
@RequiredArgsConstructor
public class MobileVerificationCodeController {

    private final MobileVerificationCodeService mobileVerificationCodeService;

    /**
     * 发送手机验证码
     *
     * @param request 发送请求
     * @return 手机验证码返回信息
     */
    @PostMapping("/cgi/mobile-verification-codes")
    public Result sendMobileVerificationCode(@Validated @RequestBody MobileVerificationCodeSendRequest request) {
        mobileVerificationCodeService.sendMobileVerificationCode(request);
        return Result.success();
    }

}
