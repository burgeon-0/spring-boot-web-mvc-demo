package org.burgeon.yi.mall.service.converter;

import org.burgeon.yi.mall.common.model.user.UserRequest;
import org.burgeon.yi.mall.common.model.user.UserResponse;
import org.burgeon.yi.mall.repository.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author Sam Lu
 * @date 2022/2/23
 */
@Mapper
public interface UseConverter {

    UseConverter INSTANCE = Mappers.getMapper(UseConverter.class);

    /**
     * {@link UserRequest} -> {@link User}
     *
     * @param userRequest
     * @return
     */
    User toUser(UserRequest userRequest);

    /**
     * {@link User} -> {@link UserResponse}
     *
     * @param user
     * @return
     */
    UserResponse toUserResponse(User user);

}
