package org.burgeon.yi.boot.redis;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;

/**
 * @author Sam Lu
 * @date 2022/06/25
 */
@Getter
public class RedisProperties {

    @Value("${app.config.redis.projectKeyPrefix:org.burgeon.yi.boot.redis}")
    private String redisProjectKeyPrefix;

}
