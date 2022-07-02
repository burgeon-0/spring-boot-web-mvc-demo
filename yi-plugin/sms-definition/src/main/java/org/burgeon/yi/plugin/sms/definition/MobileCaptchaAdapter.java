package org.burgeon.yi.plugin.sms.definition;

/**
 * 手机验证码适配器
 *
 * @author Sam Lu
 * @date 2022/07/02
 */
public interface MobileCaptchaAdapter {

    /**
     * 发送手机验证码
     *
     * @param mobile 手机号
     * @param type 验证码类型
     */
    void sendMobileCaptcha(String mobile, MobileCaptchaType type);

    /**
     * 校验手机验证码
     *
     * @param mobile 手机号
     * @param type 验证码类型
     * @param code 手机验证码
     * @return true - 验证成功，false - 验证失败
     */
    boolean checkMobileCaptcha(String mobile, MobileCaptchaType type, String code);

}
