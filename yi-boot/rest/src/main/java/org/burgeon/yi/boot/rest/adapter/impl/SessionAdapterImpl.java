package org.burgeon.yi.boot.rest.adapter.impl;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import lombok.RequiredArgsConstructor;
import org.burgeon.yi.boot.definition.cache.Cache;
import org.burgeon.yi.boot.definition.cache.CacheFactory;
import org.burgeon.yi.boot.definition.cache.CacheProperties;
import org.burgeon.yi.boot.rest.adapter.Session;
import org.burgeon.yi.boot.rest.adapter.SessionAdapter;
import org.burgeon.yi.boot.rest.utils.CookieUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
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

    @Override
    public Session getSession(HttpServletRequest request) {
        return getSession(request, false);
    }

    @Override
    public Session getSession(HttpServletRequest request, boolean create) {
        Session session = sessionThreadLocal.get();
        if (session != null) {
            return session;
        }

        // 从HttpServletRequest中获取sessionId
        String sessionId = CookieUtils.getValue(request, DefaultSession.COOKIE_KEY_SESSION_ID);

        // 如果取不到sessionId，并且create为false，则直接返回null
        if (StrUtil.isBlank(sessionId) && !create) {
            return null;
        }

        // 如果sessionId为null，并且create为true，则创建sessionId
        if (StrUtil.isBlank(sessionId)) {
            sessionId = UUID.randomUUID().toString();
        }

        // 从缓存中获取session值
        Cache<String> cache = cacheFactory.getCache(getCacheKey(sessionId));
        String valuesJson = cache.get();

        DefaultSession defaultSession = new DefaultSession(request, sessionId);
        if (StrUtil.isBlank(valuesJson)) {
            defaultSession.refreshCsrfToken();
        } else {
            defaultSession.setValues(valuesJson);
        }
        sessionThreadLocal.set(defaultSession);
        return defaultSession;
    }

    @Override
    public void setSession(HttpServletResponse response, Session session) {
        DefaultSession defaultSession = (DefaultSession) session;

        // 设置浏览器cookie
        addCookie(response, DefaultSession.COOKIE_KEY_SESSION_ID, session.getSessionId());
        addCookie(response, defaultSession.getCsrfTokenCookieKey(), defaultSession.getCsrfToken());

        // 缓存session值
        Cache<String> cache = cacheFactory.getCache(getCacheKey(session.getSessionId()));
        cache.set(defaultSession.getValues(), sessionMaxAge, TimeUnit.HOURS);

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
        cookie.setMaxAge((int) (sessionMaxAge * 60 * 60));
        cookie.setHttpOnly(true);
        response.addCookie(cookie);
    }

    /**
     * 获取缓存Key
     *
     * @param sessionId
     * @return 缓存Key
     */
    private String getCacheKey(String sessionId) {
        return StrUtil.format("{}:session:{}", cacheProperties.getCacheKeyPrefix(), sessionId);
    }

}
