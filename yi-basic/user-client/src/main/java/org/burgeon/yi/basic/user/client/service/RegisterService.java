package org.burgeon.yi.basic.user.client.service;

/**
 * 注册服务
 *
 * @author Sam Lu
 * @date 2022/07/02
 */
public interface RegisterService {

    /**
     * 发送注册验证码
     *
     * @param mobile 手机号
     */
    void sendMobileCaptcha(String mobile);

    /**
     * 通过手机验证码注册
     *
     * @param mobile 手机号
     * @param code 手机验证码
     */
    String registerByMobileCaptcha(String mobile, String code);

}
