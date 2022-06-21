package org.burgeon.yi.basic.user.adapter.cgi;

import lombok.RequiredArgsConstructor;
import org.burgeon.yi.basic.user.client.dto.response.MobileVerificationCodeResponse;
import org.burgeon.yi.basic.user.client.service.MobileVerificationCodeService;
import org.burgeon.yi.boot.definition.web.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
     * 获取手机验证码
     *
     * @param mobile 手机
     * @param verificationCodeType 验证码类型
     * @return 手机验证码返回信息
     */
    @GetMapping("/cgi/mobile-verification-codes")
    public Result<MobileVerificationCodeResponse> getMobileVerificationCode(
            @RequestParam("mobile") String mobile,
            @RequestParam("verification_code_type") String verificationCodeType) {
        return Result.success(mobileVerificationCodeService.getMobileVerificationCode(mobile, verificationCodeType));
    }

}
