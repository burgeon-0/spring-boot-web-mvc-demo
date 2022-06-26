package org.burgeon.yi.basic.user.infrastructure.gateway;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.burgeon.yi.basic.user.domain.UserServiceErrorEnum;
import org.burgeon.yi.basic.user.domain.mobileverificationcode.MobileVerificationCode;
import org.burgeon.yi.basic.user.domain.mobileverificationcode.gateway.MobileVerificationCodeGateway;
import org.burgeon.yi.boot.definition.cache.Cache;
import org.burgeon.yi.boot.definition.cache.CacheFactory;
import org.burgeon.yi.boot.definition.exception.AssertX;
import org.burgeon.yi.boot.redis.RedisProperties;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author Sam Lu
 * @date 2022/06/25
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class MobileVerificationCodeGatewayImpl implements MobileVerificationCodeGateway {

    private final CacheFactory cacheFactory;
    private final RedisProperties redisProperties;

    /**
     * 是否是debug模式
     * <p>
     * debug模式下，手机验证码不发送，且默认值为：888888
     */
    @Value("${app.config.mobileVerificationCode.debug:true}")
    private boolean debug;
    /**
     * 手机验证码有效期，单位为分钟
     */
    @Value("${app.config.mobileVerificationCode.expiresIn:10}")
    private int expiresIn;

    @Override
    public MobileVerificationCode init(MobileVerificationCode mobileVerificationCode) {
        mobileVerificationCode.setCode(debug ? "888888" : RandomUtil.randomNumbers(6));
        mobileVerificationCode.setExpiresIn(expiresIn);
        return mobileVerificationCode;
    }

    @Override
    public MobileVerificationCode send(MobileVerificationCode mobileVerificationCode) {
        log.info("Send mobileVerificationCode: {}", mobileVerificationCode);
        if (!debug) {
            // TODO 发送手机验证码
        }

        // 缓存手机验证码
        Cache<String> cache = cacheFactory.getCache(getCacheKey(mobileVerificationCode));
        cache.set(JSONUtil.toJsonStr(mobileVerificationCode), mobileVerificationCode.getExpiresIn(),
                TimeUnit.MINUTES);
        return mobileVerificationCode;
    }

    @Override
    public MobileVerificationCode check(MobileVerificationCode mobileVerificationCode) {
        // 查看手机验证码是否存在
        Cache<String> cache = cacheFactory.getCache(getCacheKey(mobileVerificationCode));
        String json = cache.get();
        AssertX.isNotNull(json, UserServiceErrorEnum.MOBILE_VERIFICATION_CODE_NOT_EXIST_OR_EXPIRED);

        // 检验手机验证码
        MobileVerificationCode cachedMobileVerificationCode = JSONUtil.toBean(json, MobileVerificationCode.class);
        AssertX.isTrue(cachedMobileVerificationCode.getCode().equals(mobileVerificationCode.getCode()),
                UserServiceErrorEnum.MOBILE_VERIFICATION_CODE_INVALID);

        // 删除已使用的手机验证码
        cache.delete();

        return cachedMobileVerificationCode;
    }

    /**
     * 获取缓存Key
     *
     * @param mobileVerificationCode
     * @return
     */
    private String getCacheKey(MobileVerificationCode mobileVerificationCode) {
        return StrUtil.format("{}:mobileVerificationCode:{}-{}",
                redisProperties.getRedisProjectKeyPrefix(),
                mobileVerificationCode.getMobile(),
                mobileVerificationCode.getType());
    }

}
