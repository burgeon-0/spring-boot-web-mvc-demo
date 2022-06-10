package org.burgeon.aero.as.domain.repository;

import org.burgeon.aero.as.domain.entity.Realm;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Sam Lu
 * @date 2021/11/26
 */
public interface RealmRepository extends JpaRepository<Realm, Long> {

    /**
     * Find Realm by name
     *
     * @param name
     * @return
     */
    Realm findByName(String name);

}
