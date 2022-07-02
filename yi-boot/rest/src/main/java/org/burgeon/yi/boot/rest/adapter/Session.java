package org.burgeon.yi.boot.rest.adapter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Sam Lu
 * @date 2022/07/02
 */
@RequiredArgsConstructor
public abstract class Session {

    @Getter
    private final String sessionId;

    protected Map<String, Object> values = new ConcurrentHashMap<>();

    public Object get(String key) {
        return values.get(key);
    }

    public void put(String key, Object value) {
        values.put(key, value);
    }

    public abstract boolean checkCsrfToken();

}
