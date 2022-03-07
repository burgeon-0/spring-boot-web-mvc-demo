package org.burgeon.mvc.service;

import lombok.RequiredArgsConstructor;
import org.burgeon.mvc.common.exception.Assert;
import org.burgeon.mvc.common.exception.ErrorEnum;
import org.burgeon.mvc.repository.UserRepository;
import org.burgeon.mvc.repository.entity.User;
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
        Assert.isEmpty(users, ErrorEnum.DUPLICATE_MOBILE);
    }

    public void checkEmailDuplicate(String email) {
        List<User> users = userRepository.findByEmail(email);
        Assert.isEmpty(users, ErrorEnum.DUPLICATE_EMAIL);
    }

}
