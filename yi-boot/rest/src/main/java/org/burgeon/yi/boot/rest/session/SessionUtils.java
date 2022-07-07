package org.burgeon.yi.boot.rest.session;

import org.burgeon.yi.boot.common.context.AppContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Sam Lu
 * @date 2022/07/07
 */
public class SessionUtils {

    private static SessionAdapter sessionAdapter;

    static {
        new SessionUtils();
    }

    private SessionUtils() {
        sessionAdapter = AppContext.getBean(SessionAdapter.class);
    }

    public static Session getSession(HttpServletRequest request) {
        return sessionAdapter.getSession(request);
    }

    public static Session getSession(HttpServletRequest request, boolean create) {
        return sessionAdapter.getSession(request, create);
    }

    public static void setSession(HttpServletResponse response, Session session) {
        sessionAdapter.setSession(response, session);
    }

    public static void storeSession(Session session) {
        sessionAdapter.storeSession(session);
    }

    public static void clear() {
        sessionAdapter.clear();
    }

}
