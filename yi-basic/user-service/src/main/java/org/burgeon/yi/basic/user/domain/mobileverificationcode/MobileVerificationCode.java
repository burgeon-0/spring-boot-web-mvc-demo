package org.burgeon.yi.basic.user.domain.mobileverificationcode;

import lombok.Data;
import lombok.experimental.Accessors;
import org.burgeon.yi.basic.user.domain.mobileverificationcode.gateway.MobileVerificationCodeGateway;
import org.burgeon.yi.boot.common.AppContext;

/**
 * 手机验证码
 *
 * @author Sam Lu
 * @date 2022/06/24
 */
@Data
@Accessors(chain = true)
public class MobileVerificationCode {

    /**
     * 手机
     */
    private String mobile;

    /**
     * 验证码类型
     */
    private MobileVerificationCodeTypeEnum type;

    /**
     * 验证码
     */
    private String code;

    /**
     * 有效期
     */
    private Integer expiresIn;

    /**
     * 初始化手机验证码
     *
     * @return
     */
    public MobileVerificationCode init() {
        return getMobileVerificationCodeGateway().init(this);
    }

    /**
     * 发送手机验证码
     *
     * @return
     */
    public MobileVerificationCode send() {
        return getMobileVerificationCodeGateway().send(this);
    }

    /**
     * 校验手机验证码
     *
     * @return
     */
    public MobileVerificationCode check() {
        return getMobileVerificationCodeGateway().check(this);
    }

    private MobileVerificationCodeGateway getMobileVerificationCodeGateway() {
        return AppContext.getBean(MobileVerificationCodeGateway.class);
    }

}
