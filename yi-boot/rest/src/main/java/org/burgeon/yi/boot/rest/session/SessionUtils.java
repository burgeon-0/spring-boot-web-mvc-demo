package org.burgeon.yi.boot.rest.session;

import org.burgeon.yi.boot.common.context.AppContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Sam Lu
 * @date 2022/07/07
 */
public class SessionUtils {

    private static class Holder {

        private static SessionUtils INSTANCE = new SessionUtils();

    }

    private SessionAdapter sessionAdapter;

    private SessionUtils() {
        sessionAdapter = AppContext.getBean(SessionAdapter.class);
    }

    public static Session getSession(HttpServletRequest request) {
        return Holder.INSTANCE.sessionAdapter.getSession(request);
    }

    public static Session getSession(HttpServletRequest request, boolean create) {
        return Holder.INSTANCE.sessionAdapter.getSession(request, create);
    }

    public static void setSession(HttpServletResponse response, Session session) {
        Holder.INSTANCE.sessionAdapter.setSession(response, session);
    }

    public static void storeSession(Session session) {
        Holder.INSTANCE.sessionAdapter.storeSession(session);
    }

    public static void clear() {
        Holder.INSTANCE.sessionAdapter.clear();
    }

}
