package org.burgeon.aero.as.app.init;

import org.burgeon.aero.as.domain.entity.Realm;
import org.burgeon.aero.as.domain.repository.RealmRepository;
import org.burgeon.aero.as.infra.Constants;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author Sam Lu
 * @date 2021/12/1
 */
@Component
public class InitData implements InitializingBean {

    @Autowired
    private RedissonClient redissonClient;

    @Autowired
    private RealmRepository realmRepository;

    @Override
    public void afterPropertiesSet() throws Exception {
        RLock lock = redissonClient.getLock(Constants.REDIS_KEY_PREFIX + "init_data_lock");
        if (!lock.isLocked()) {
            lock.lock(30, TimeUnit.SECONDS);
            try {
                init();
            } finally {
                lock.unlock();
            }
        }
    }

    private void init() {
        String defaultRealmName = Constants.DEFAULT_REALM_NAME;
        Realm realm = realmRepository.findByName(defaultRealmName);
        if (realm == null) {
            realm = new Realm();
            realm.setName(Constants.DEFAULT_REALM_NAME);
            realmRepository.save(realm);
        }
    }

}
