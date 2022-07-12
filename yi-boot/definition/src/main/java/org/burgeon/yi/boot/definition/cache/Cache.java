package org.bg181.yi.boot.definition.cache;

import java.util.concurrent.TimeUnit;

/**
 * 缓存
 *
 * @author Sam Lu
 * @date 2022/06/24
 */
public interface Cache<V> {

    /**
     * 获取缓存值
     *
     * @return 缓存值
     */
    V get();

    /**
     * 设置缓存值
     *
     * @param value 缓存值
     * @param cacheTime 缓存时间
     * @param timeUnit 缓存时间单位
     */
    void set(V value, long cacheTime, TimeUnit timeUnit);

    /**
     * 删除缓存值
     */
    void delete();

}
