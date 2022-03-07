package org.burgeon.mvc.controller;

import lombok.RequiredArgsConstructor;
import org.burgeon.mvc.service.UserService;
import org.burgeon.mvc.common.model.Response;
import org.burgeon.mvc.common.model.SingleResponse;
import org.burgeon.mvc.common.model.user.UserRequest;
import org.burgeon.mvc.common.model.user.UserResponse;
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

    @PostMapping("/api/users")
    public SingleResponse<UserResponse> create(@RequestBody @Validated UserRequest request) {
        return userService.create(request);
    }

    @PutMapping("/api/users/{userId}")
    public SingleResponse<UserResponse> update(@PathVariable("userId") Long userId,
                                               @RequestBody @Validated UserRequest request) {
        return userService.update(userId, request);
    }

    @DeleteMapping("/api/users/{userId}")
    public Response delete(@PathVariable("userId") Long userId) {
        return userService.delete(userId);
    }

    @GetMapping("/api/users/{userId}")
    public SingleResponse<UserResponse> getById(@PathVariable("userId") Long userId) {
        return userService.getById(userId);
    }

}
