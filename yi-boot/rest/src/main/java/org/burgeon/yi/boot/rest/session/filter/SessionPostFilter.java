package org.burgeon.yi.boot.rest.session.filter;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.burgeon.yi.boot.rest.session.Session;
import org.burgeon.yi.boot.rest.session.SessionAdapter;
import org.burgeon.yi.boot.rest.session.SessionConstants;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Sam Lu
 * @date 2022/07/02
 */
@Slf4j
@Order(Ordered.LOWEST_PRECEDENCE)
@RequiredArgsConstructor
public class SessionPostFilter implements Filter {

    private final SessionAdapter sessionAdapter;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String uri = httpServletRequest.getRequestURI();
        if (uri.toLowerCase().endsWith(SessionConstants.HTML_SUFFIX)) {
            Session session = sessionAdapter.getSession((HttpServletRequest) request);
            if (session != null) {
                sessionAdapter.setSession((HttpServletResponse) response, session);
            }
        }
        chain.doFilter(request, response);
    }

}
