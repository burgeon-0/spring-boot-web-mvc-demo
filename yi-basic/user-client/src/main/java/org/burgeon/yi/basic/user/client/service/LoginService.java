package org.burgeon.yi.basic.user.client.service;

/**
 * 登录服务
 *
 * @author Sam Lu
 * @date 2022/07/02
 */
public interface LoginService {

    /**
     * 发送登录验证码
     *
     * @param mobile 手机号
     */
    void sendMobileCaptcha(String mobile);

    /**
     * 通过手机验证码登录
     *
     * @param mobile 手机号
     * @param code 手机验证码
     */
    String loginByMobileCaptcha(String mobile, String code);

}
