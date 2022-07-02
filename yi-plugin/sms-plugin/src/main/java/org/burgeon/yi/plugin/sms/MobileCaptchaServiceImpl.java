package org.burgeon.yi.plugin.sms;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.burgeon.yi.boot.definition.cache.Cache;
import org.burgeon.yi.boot.definition.cache.CacheFactory;
import org.burgeon.yi.boot.definition.cache.CacheProperties;
import org.burgeon.yi.boot.definition.exception.AssertX;
import org.burgeon.yi.plugin.sms.definition.MobileCaptchaService;
import org.burgeon.yi.plugin.sms.definition.MobileCaptchaType;
import org.springframework.beans.factory.annotation.Value;

import java.util.concurrent.TimeUnit;

/**
 * 手机验证码服务
 *
 * @author Sam Lu
 * @date 2022/07/02
 */
@Slf4j
@RequiredArgsConstructor
public class MobileCaptchaServiceImpl implements MobileCaptchaService {

    private final CacheFactory cacheFactory;
    private final CacheProperties cacheProperties;

    /**
     * true - 输出发送手机验证码的日志<br/>
     * false - 不输出发送手机验证码的日志
     */
    @Value("${yi.plugin.sms.mobileCaptcha.show:true}")
    private boolean show;
    /**
     * 是否是debug模式
     * <p>
     * debug模式下，手机验证码不发送，且默认值为：888888
     */
    @Value("${yi.plugin.sms.mobileCaptcha.debug:true}")
    private boolean debug;
    /**
     * 手机验证码有效期，单位为分钟
     */
    @Value("${yi.plugin.sms.mobileCaptcha.expiresIn:10}")
    private int expiresIn;

    @Override
    public void sendMobileCaptcha(String mobile, MobileCaptchaType type) {
        // 生成手机验证码
        String code;
        if (debug) {
            code = "888888";
        } else {
            code = RandomUtil.randomNumbers(6);
        }

        if (show) {
            log.info("Send mobileCaptcha => mobile: {}, type: {}, code: {}", mobile, type.getType(), code);
        }

        // 发送手机验证码
        if (!debug) {
            // TODO 发送手机验证码
        }

        // 缓存手机验证码
        Cache<String> cache = cacheFactory.getCache(getCacheKey(mobile, type));
        cache.set(code, expiresIn, TimeUnit.MINUTES);
    }

    @Override
    public boolean checkMobileCaptcha(String mobile, MobileCaptchaType type, String code) {
        // 查看手机验证码是否存在
        Cache<String> cache = cacheFactory.getCache(getCacheKey(mobile, type));
        String cachedCode = cache.get();
        if (StrUtil.isBlank(cachedCode)) {
            return false;
        }

        // 检验手机验证码
        if (!cachedCode.equals(code)) {
            return false;
        }

        // 删除已使用的手机验证码
        cache.delete();
        return true;
    }

    /**
     * 获取缓存Key
     *
     * @param mobile 手机号
     * @param type 验证码类型
     * @return
     */
    private String getCacheKey(String mobile, MobileCaptchaType type) {
        return StrUtil.format("{}:mobileCaptcha:{}-{}", cacheProperties.getCacheKeyPrefix(),
                mobile, type.getType());
    }

}
