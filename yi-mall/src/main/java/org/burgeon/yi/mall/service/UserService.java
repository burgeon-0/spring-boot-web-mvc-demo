package org.burgeon.yi.mall.service;

import lombok.RequiredArgsConstructor;
import org.burgeon.yi.mall.common.enums.ErrorEnum;
import org.burgeon.yi.mall.common.model.user.UserRequest;
import org.burgeon.yi.mall.common.model.user.UserResponse;
import org.burgeon.yi.mall.repository.UserRepository;
import org.burgeon.yi.mall.repository.entity.User;
import org.burgeon.yi.mall.service.converter.UseConverter;
import org.burgeon.yi.rest.exception.AssertX;
import org.burgeon.yi.rest.model.Response;
import org.burgeon.yi.rest.model.SingleResponse;
import org.springframework.stereotype.Service;

/**
 * @author Sam Lu
 * @date 2022/2/23
 */
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserValidator userValidator;
    private final UserRepository userRepository;

    public SingleResponse<UserResponse> create(UserRequest request) {
        userValidator.checkMobileDuplicate(request.getMobile());
        userValidator.checkEmailDuplicate(request.getEmail());

        User user = UseConverter.INSTANCE.toUser(request);
        user = userRepository.save(user);
        return SingleResponse.created(UseConverter.INSTANCE.toUserResponse(user));
    }

    public SingleResponse<UserResponse> update(Long userId, UserRequest request) {
        User oldUser = userRepository.findOneById(userId);
        if (isMobileNew(oldUser, request.getMobile())) {
            userValidator.checkMobileDuplicate(request.getMobile());
        }
        if (isEmailNew(oldUser, request.getEmail())) {
            userValidator.checkEmailDuplicate(request.getEmail());
        }

        User user = UseConverter.INSTANCE.toUser(request);
        user.setId(userId);
        user = userRepository.save(user);
        return SingleResponse.ok(UseConverter.INSTANCE.toUserResponse(user));
    }

    private boolean isMobileNew(User oldUser, String mobile) {
        return !oldUser.getMobile().equals(mobile);
    }

    private boolean isEmailNew(User oldUser, String email) {
        return !oldUser.getEmail().equals(email);
    }

    public Response delete(Long userId) {
        User user = userRepository.findOneById(userId);
        AssertX.notNull(user, ErrorEnum.USER_NOT_FOUND);

        userRepository.deleteById(userId);
        return SingleResponse.ok();
    }

    public SingleResponse<UserResponse> getById(Long userId) {
        User user = userRepository.findOneById(userId);
        AssertX.notNull(user, ErrorEnum.USER_NOT_FOUND);

        return SingleResponse.ok(UseConverter.INSTANCE.toUserResponse(user));
    }

}
