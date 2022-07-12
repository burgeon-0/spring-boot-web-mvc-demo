package org.bg181.yi.boot.rest.session.impl;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.crypto.digest.MD5;
import cn.hutool.json.JSONUtil;
import org.bg181.yi.boot.rest.session.Session;
import org.bg181.yi.boot.rest.utils.CookieUtils;
import org.bg181.yi.boot.rest.session.SessionFilter;

import javax.servlet.http.HttpServletRequest;
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

    /**
     * 注意：clear的时候，csrfToken不会被清除
     * （csrfToken是自动生成的：{@link SessionAdapterImpl#getSession(HttpServletRequest, boolean)}）
     */
    @Override
    public void clear() {
        String csrfToken = getCsrfToken();
        values.clear();
        values.put(CSRF_TOKEN_KEY, csrfToken);
    }

    @Override
    public boolean checkCsrfToken() {
        String cachedCsrfToken = getCsrfToken();
        String csrfTokenCookieKey = getCsrfTokenCookieKey();
        String cookieCsrfToken = CookieUtils.getValue(request, csrfTokenCookieKey);
        return cachedCsrfToken.equals(cookieCsrfToken);
    }

    public void refreshCsrfToken() {
        super.put(CSRF_TOKEN_KEY, RandomUtil.randomStringUpper(12));
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
