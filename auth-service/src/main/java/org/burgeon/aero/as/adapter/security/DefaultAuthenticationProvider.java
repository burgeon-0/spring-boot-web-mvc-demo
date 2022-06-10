package org.burgeon.aero.as.adapter.security;

import lombok.extern.slf4j.Slf4j;
import org.burgeon.aero.as.app.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Component;

/**
 * @author Sam Lu
 * @date 2021/11/22
 */
@Slf4j
@Component
public class DefaultAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private AccountService accountService;

    @Override
    public Authentication authenticate(Authentication auth) throws AuthenticationException {
        String username = auth.getName();
        String password = auth.getCredentials().toString();

        log.debug("User Login, Username: {}, Password: {}", username, password);
        try {
            accountService.login(username, password);
            log.info("User Login Success, Username: {}", username);
            return new UsernamePasswordAuthenticationToken(username, password,
                    AuthorityUtils.createAuthorityList("ROLE_USER"));
        } catch (Exception e) {
            log.info("User Login Fail, Username: {}", username);
            throw new BadCredentialsException("External System Authentication Failed");
        }
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(UsernamePasswordAuthenticationToken.class);
    }

}
