package org.burgeon.aero.as.app.service;

import lombok.extern.slf4j.Slf4j;
import org.burgeon.aero.as.domain.entity.Account;
import org.burgeon.aero.as.domain.entity.Realm;
import org.burgeon.aero.as.domain.entity.User;
import org.burgeon.aero.as.domain.repository.AccountRepository;
import org.burgeon.aero.as.domain.repository.RealmRepository;
import org.burgeon.aero.as.domain.repository.UserRepository;
import org.burgeon.aero.as.infra.Constants;
import org.burgeon.aero.as.infra.exception.ErrorCode;
import org.burgeon.aero.as.infra.exception.RestException;
import org.burgeon.aero.as.infra.utils.ShaUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

/**
 * @author Sam Lu
 * @date 2021/11/30
 */
@Slf4j
@Service
public class AccountService {

    @Autowired
    private RealmRepository realmRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private UserRepository userRepository;

    public void login(String username, String password) {
        Realm realm = realmRepository.findByName(Constants.DEFAULT_REALM_NAME);
        if (realm == null) {
            log.error("Default Realm Not Initial");
            throw new RestException(ErrorCode.USERNAME_OR_PASSWORD_ERROR);
        }

        login(realm.getId(), username, password);
    }

    public void login(Long realmId, String username, String password) {
        Account account = accountRepository.findByRealmIdAndUsername(realmId, username);
        if (account == null) {
            throw new RestException(ErrorCode.USERNAME_OR_PASSWORD_ERROR);
        }

        UUID userId = account.getUserId();
        Optional<User> userOptional = userRepository.findById(userId);
        if (!userOptional.isPresent()) {
            log.warn("Abnormal Account Data, Username: {}", username);
            throw new RestException(ErrorCode.USERNAME_OR_PASSWORD_ERROR);
        }

        User user = userOptional.get();
        password = ShaUtils.sha256(password, user.getSalt());
        if (!password.equals(user.getPassword())) {
            throw new RestException(ErrorCode.USERNAME_OR_PASSWORD_ERROR);
        }
    }

}
