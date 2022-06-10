package org.burgeon.aero.as.domain.repository;

import org.burgeon.aero.as.domain.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * @author Sam Lu
 * @date 2021/11/26
 */
public interface AccountRepository extends JpaRepository<Account, UUID> {

    /**
     * Find Account by username and password
     *
     * @param realmId
     * @param username
     * @return
     */
    Account findByRealmIdAndUsername(Long realmId, String username);

}
