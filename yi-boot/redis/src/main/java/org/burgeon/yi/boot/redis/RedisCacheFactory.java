package org.burgeon.yi.boot.redis;

import lombok.RequiredArgsConstructor;
import org.burgeon.yi.boot.definition.cache.Cache;
import org.burgeon.yi.boot.definition.cache.CacheFactory;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;

/**
 * Redis缓存工厂
 *
 * @author Sam Lu
 * @date 2022/06/24
 */
@RequiredArgsConstructor
public class RedisCacheFactory implements CacheFactory {

    private final RedissonClient redissonClient;

    @Override
    public <V> Cache<V> getCache(String key) {
        RBucket<V> rBucket = redissonClient.getBucket(key);
        return new RedisCache<>(rBucket);
    }

}
