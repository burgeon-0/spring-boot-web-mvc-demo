package org.bg181.yi.boot.definition.regex;

/**
 * @author Sam Lu
 * @date 2022/07/04
 */
public class RegexPool {

    private RegexPool() {}

    /**
     * 手机正则表达式
     */
    public static final String REG_MOBILE = "^1[3-9]\\d{9}$";

    /**
     * 手机验证码正则表达式
     */
    public static final String REG_MOBILE_CAPTCHA = "^\\d{6}$";

}
