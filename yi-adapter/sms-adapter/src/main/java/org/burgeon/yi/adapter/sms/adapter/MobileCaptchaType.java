package org.burgeon.yi.adapter.sms.adapter;

/**
 * 手机验证码类型
 *
 * @author Sam Lu
 * @date 2022/07/02
 */
public interface MobileCaptchaType {

    /**
     * 验证码类型
     *
     * @return
     */
    String getType();

    /**
     * 验证码描述
     *
     * @return
     */
    String getDescription();

}
