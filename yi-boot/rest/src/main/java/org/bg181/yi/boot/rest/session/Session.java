package org.bg181.yi.boot.rest.session;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

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

    public void remove(String key) {
        values.remove(key);
    }

    public void clear() {
        values.clear();
    }

    /**
     * 校验csrfToken
     *
     * @return
     */
    public abstract boolean checkCsrfToken();

    /**
     * 更新csrfToken
     */
    public abstract void refreshCsrfToken();

}
