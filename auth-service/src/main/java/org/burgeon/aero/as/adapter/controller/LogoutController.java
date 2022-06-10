package org.burgeon.aero.as.adapter.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Sam Lu
 * @date 2021/11/3
 */
@Slf4j
@RestController
public class LogoutController {

    @GetMapping("/logout")
    public RedirectView logout(HttpServletRequest request, HttpServletResponse response,
                               Authentication auth) {
        UserDetails userDetails = (UserDetails) auth.getPrincipal();
        log.info("User Logout, Username: {}", userDetails.getUsername());

        SecurityContextLogoutHandler logoutHandler = new SecurityContextLogoutHandler();
        logoutHandler.logout(request, response, auth);
        return new RedirectView("/login");
    }

}
