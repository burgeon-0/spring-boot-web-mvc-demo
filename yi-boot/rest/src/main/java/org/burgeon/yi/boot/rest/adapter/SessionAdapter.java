package org.burgeon.yi.boot.rest.adapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
     *
     * @param response HttpServletResponse
     * @param session Session
     */
    void setSession(HttpServletResponse response, Session session);

}
