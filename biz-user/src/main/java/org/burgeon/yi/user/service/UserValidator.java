package org.burgeon.yi.user.service;

import lombok.RequiredArgsConstructor;
import org.burgeon.yi.user.common.enums.ErrorEnum;
import org.burgeon.yi.user.repository.entity.User;
import org.burgeon.yi.user.repository.UserRepository;
import org.burgeon.yi.rest.exception.AssertX;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Sam Lu
 * @date 2022/2/24
 */
@Component
@RequiredArgsConstructor
public class UserValidator {

    private final UserRepository userRepository;

    public void checkMobileDuplicate(String mobile) {
        List<User> users = userRepository.findByMobile(mobile);
        AssertX.isEmpty(users, ErrorEnum.DUPLICATE_MOBILE);
    }

    public void checkEmailDuplicate(String email) {
        List<User> users = userRepository.findByEmail(email);
        AssertX.isEmpty(users, ErrorEnum.DUPLICATE_EMAIL);
    }

}
