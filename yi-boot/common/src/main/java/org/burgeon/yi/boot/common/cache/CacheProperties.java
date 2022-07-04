package org.burgeon.yi.boot.common.cache;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;

/**
 * 缓存配置
 *
 * @author Sam Lu
 * @date 2022/07/02
 */
@Getter
public class CacheProperties {

    /**
     * 缓存Key前缀
     */
    @Value("${yi.boot.common.cacheKeyPrefix:org.burgeon.yi.boot}")
    private String cacheKeyPrefix;

}
