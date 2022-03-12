package org.burgeon.yi.mall.repository;

import org.burgeon.yi.mall.repository.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author Sam Lu
 * @date 2022/2/23
 */
public interface UserRepository extends CrudRepository<User, Long> {

    /**
     * Find users by mobile
     *
     * @param mobile
     * @return
     */
    List<User> findByMobile(String mobile);

    /**
     * Find users by email
     *
     * @param email
     * @return
     */
    List<User> findByEmail(String email);

    /**
     * Find user by id
     *
     * @param id
     * @return
     */
    User findOneById(Long id);

}
