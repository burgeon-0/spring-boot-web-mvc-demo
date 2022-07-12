package org.bg181.yi.boot.redis;

import lombok.AllArgsConstructor;
import org.bg181.yi.boot.definition.cache.Cache;
import org.redisson.api.RBucket;

import java.util.concurrent.TimeUnit;

/**
 * Redis缓存
 *
 * @author Sam Lu
 * @date 2022/06/24
 */
@AllArgsConstructor
public class RedisCache<V> implements Cache<V> {

    private RBucket<V> rBucket;

    @Override
    public V get() {
        return rBucket.get();
    }

    @Override
    public void set(V value, long cacheTime, TimeUnit timeUnit) {
        rBucket.set(value, cacheTime, timeUnit);
    }

    @Override
    public void delete() {
        rBucket.delete();
    }

}
