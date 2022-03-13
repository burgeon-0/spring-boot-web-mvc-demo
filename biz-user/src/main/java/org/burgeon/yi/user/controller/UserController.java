package org.burgeon.yi.user.controller;

import lombok.RequiredArgsConstructor;
import org.burgeon.yi.user.common.model.user.UserRequest;
import org.burgeon.yi.user.common.model.user.UserResponse;
import org.burgeon.yi.user.service.UserService;
import org.burgeon.yi.rest.model.Response;
import org.burgeon.yi.rest.model.SingleResponse;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author Sam Lu
 * @date 2022/2/23
 */
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    /**
     * 创建用户
     *
     * @param request
     * @return
     */
    @PostMapping("/api/users")
    public SingleResponse<UserResponse> create(@RequestBody @Validated UserRequest request) {
        return userService.create(request);
    }

    /**
     * 修改用户
     *
     * @param userId
     * @param request
     * @return
     */
    @PutMapping("/api/users/{userId}")
    public SingleResponse<UserResponse> update(@PathVariable("userId") Long userId,
                                               @RequestBody @Validated UserRequest request) {
        return userService.update(userId, request);
    }

    /**
     * 删除用户
     *
     * @param userId
     * @return
     */
    @DeleteMapping("/api/users/{userId}")
    public Response delete(@PathVariable("userId") Long userId) {
        return userService.delete(userId);
    }

    /**
     * 查询用户
     *
     * @param userId
     * @return
     */
    @GetMapping("/api/users/{userId}")
    public SingleResponse<UserResponse> getById(@PathVariable("userId") Long userId) {
        return userService.getById(userId);
    }

}
