package org.burgeon.yi.boot.rest.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

/**
 * @author Sam Lu
 * @date 2022/07/02
 */
public class CookieUtils {

    private CookieUtils() {}

    public static String getValue(HttpServletRequest request, String key) {
        if (Objects.isNull(key)) {
            return null;
        }
        Cookie[] cookies = request.getCookies();
        if (Objects.isNull(cookies)) {
            return null;
        }
        for (Cookie cookie : cookies) {
            if (key.equals(cookie.getName())) {
                return cookie.getValue();
            }
        }
        return null;
    }

}
