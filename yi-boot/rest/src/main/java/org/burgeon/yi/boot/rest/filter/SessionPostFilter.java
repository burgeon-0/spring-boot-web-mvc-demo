package org.burgeon.yi.boot.rest.filter;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.burgeon.yi.boot.rest.adapter.Session;
import org.burgeon.yi.boot.rest.adapter.SessionAdapter;
import org.burgeon.yi.boot.rest.constant.RestConstants;
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
@Order(Integer.MAX_VALUE)
@RequiredArgsConstructor
public class SessionPostFilter implements Filter {

    private final SessionAdapter sessionAdapter;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String uri = httpServletRequest.getRequestURI();
        if (RestConstants.PATTERN_STATIC_URI.matcher(uri).find()) {
            Session session = sessionAdapter.getSession((HttpServletRequest) request);
            if (session != null) {
                sessionAdapter.setSession((HttpServletResponse) response, session);
            }
        }
        chain.doFilter(request, response);
    }

}
