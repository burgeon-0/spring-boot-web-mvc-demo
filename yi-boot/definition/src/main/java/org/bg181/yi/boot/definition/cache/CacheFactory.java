package org.bg181.yi.boot.definition.cache;

/**
 * 缓存工厂
 *
 * @author Sam Lu
 * @date 2022/06/24
 */
public interface CacheFactory {

    /**
     * 获取缓存
     *
     * @param key 缓存key
     * @param <V> 缓存值类型
     * @return 缓存
     */
    <V> Cache<V> getCache(String key);

}
