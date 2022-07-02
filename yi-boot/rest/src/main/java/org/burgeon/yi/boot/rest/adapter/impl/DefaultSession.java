package org.burgeon.yi.boot.rest.adapter.impl;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.crypto.digest.MD5;
import cn.hutool.json.JSONUtil;
import org.burgeon.yi.boot.rest.adapter.Session;
import org.burgeon.yi.boot.rest.utils.CookieUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Sam Lu
 * @date 2022/07/02
 */
public class DefaultSession extends Session {

    public static final String COOKIE_KEY_SESSION_ID = "SSID";

    private static final String CSRF_TOKEN_KEY = "csrfToken";

    private HttpServletRequest request;

    public DefaultSession(HttpServletRequest request, String sessionId) {
        super(sessionId);
        this.request = request;
    }

    public void refreshCsrfToken() {
        super.put(CSRF_TOKEN_KEY, RandomUtil.randomStringUpper(12));
    }

    @Override
    public boolean checkCsrfToken() {
        String cachedCsrfToken = getCsrfToken();
        String csrfTokenCookieKey = getCsrfTokenCookieKey();
        String cookieCsrfToken = CookieUtils.getValue(request, csrfTokenCookieKey);
        boolean valid = cachedCsrfToken.equals(cookieCsrfToken);

        refreshCsrfToken();
        return valid;
    }

    public String getValues() {
        return JSONUtil.toJsonStr(super.values);
    }

    public void setValues(String json) {
        super.values = JSONUtil.toBean(json, ConcurrentHashMap.class);
    }

    public String getCsrfTokenCookieKey() {
        return "_" + MD5.create().digestHex(super.getSessionId()).toUpperCase();
    }

    public String getCsrfToken() {
        return (String) super.get(CSRF_TOKEN_KEY);
    }

}
