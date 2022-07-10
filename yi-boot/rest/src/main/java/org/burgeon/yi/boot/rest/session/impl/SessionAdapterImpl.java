package org.burgeon.yi.boot.rest.session.impl;

import cn.hutool.core.text.CharSequenceUtil;
import lombok.RequiredArgsConstructor;
import org.burgeon.yi.boot.common.cache.CacheProperties;
import org.burgeon.yi.boot.definition.cache.Cache;
import org.burgeon.yi.boot.definition.cache.CacheFactory;
import org.burgeon.yi.boot.rest.session.Session;
import org.burgeon.yi.boot.rest.session.SessionAdapter;
import org.burgeon.yi.boot.rest.utils.CookieUtils;
import org.springframework.beans.factory.annotation.Value;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author Sam Lu
 * @date 2022/07/02
 */
@RequiredArgsConstructor
public class SessionAdapterImpl implements SessionAdapter {

    private final CacheFactory cacheFactory;
    private final CacheProperties cacheProperties;

    private static ThreadLocal<Session> sessionThreadLocal = new ThreadLocal<>();
    // session缓存2小时
    private static long sessionMaxAge = 2;

    /**
     * 是否启用cookie的安全模式，
     * 安全模式下，只有HTTPS请求会带上cookie的内容
     */
    @Value("${yi.boot.rest.session.secure:false}")
    private boolean secure;

    @Override
    public Session getSession(HttpServletRequest request) {
        return getSession(request, false);
    }

    @Override
    public Session getSession(HttpServletRequest request, boolean create) {
        // 从ThreadLocal中获取session
        Session session = sessionThreadLocal.get();
        if (session != null) {
            return session;
        }

        // 从HttpServletRequest中获取sessionId
        String sessionId = CookieUtils.getValue(request, DefaultSession.COOKIE_KEY_SESSION_ID);

        // 如果取不到sessionId，并且create为false，则直接返回null
        if (CharSequenceUtil.isBlank(sessionId) && !create) {
            return null;
        }

        // 如果sessionId为null，并且create为true，则创建sessionId
        if (CharSequenceUtil.isBlank(sessionId)) {
            sessionId = UUID.randomUUID().toString();
        }

        // 从缓存中获取session值
        Cache<String> cache = cacheFactory.getCache(getCacheKey(sessionId));
        String valuesJson = cache.get();

        DefaultSession defaultSession = new DefaultSession(request, sessionId);
        if (CharSequenceUtil.isBlank(valuesJson)) {
            // session值为空时，自动创建csrfToken
            defaultSession.refreshCsrfToken();
        } else {
            defaultSession.setValues(valuesJson);
        }
        sessionThreadLocal.set(defaultSession);
        return defaultSession;
    }

    @Override
    public void setSession(HttpServletResponse response, Session session) {
        // 将sessionId和csrfToken设置到浏览器中
        DefaultSession defaultSession = (DefaultSession) session;
        addCookie(response, DefaultSession.COOKIE_KEY_SESSION_ID, session.getSessionId());
        addCookie(response, defaultSession.getCsrfTokenCookieKey(), defaultSession.getCsrfToken());
    }

    @Override
    public void storeSession(Session session) {
        // 缓存session值
        DefaultSession defaultSession = (DefaultSession) session;
        Cache<String> cache = cacheFactory.getCache(getCacheKey(session.getSessionId()));
        cache.set(defaultSession.getValues(), sessionMaxAge, TimeUnit.HOURS);
    }

    @Override
    public void clear() {
        // 移除ThreadLocal中的session
        sessionThreadLocal.remove();
    }

    /**
     * 设置浏览器cookie
     *
     * @param response HttpServletResponse
     * @param key cookie键
     * @param value cookie值
     */
    private void addCookie(HttpServletResponse response, String key, String value) {
        Cookie cookie = new Cookie(key, value);
        cookie.setDomain("");
        cookie.setPath("/");
        cookie.setMaxAge((int) (sessionMaxAge * 60 * 60));
        cookie.setHttpOnly(true);
        cookie.setSecure(secure);
        response.addCookie(cookie);
    }

    /**
     * 获取缓存Key
     *
     * @param sessionId
     * @return 缓存Key
     */
    private String getCacheKey(String sessionId) {
        return CharSequenceUtil.format("{}:session:{}", cacheProperties.getCacheKeyPrefix(), sessionId);
    }

}
