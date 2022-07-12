package org.bg181.yi.boot.rest.session;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bg181.yi.boot.definition.cache.Cache;

/**
 * Session适配器
 *
 * @author Sam Lu
 * @date 2022/07/02
 */
public interface SessionAdapter {

    /**
     * 获取session
     *
     * @param request HttpServletRequest
     * @return session
     */
    Session getSession(HttpServletRequest request);

    /**
     * 获取session
     *
     * @param request HttpServletRequest
     * @param create session不存在时，是否自动创建
     * @return session
     */
    Session getSession(HttpServletRequest request, boolean create);

    /**
     * 设置session
     * <p>
     * 将sessionId和csrfToken设置到浏览器中
     *
     * @param response HttpServletResponse
     * @param session Session
     */
    void setSession(HttpServletResponse response, Session session);

    /**
     * 存储session
     * <p>
     * 将session存入缓存中。
     * 可能存入本地缓存，也可能存入分布式缓存服务器，取决于具体的缓存实现 {@link Cache}
     *
     * @param session
     */
    void storeSession(Session session);

    /**
     * 清除与session有关的状态，如：{@link ThreadLocal} 中缓存的对象
     */
    void clear();

}
