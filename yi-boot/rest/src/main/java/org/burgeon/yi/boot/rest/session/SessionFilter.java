package org.burgeon.yi.boot.rest.session;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Sam Lu
 * @date 2022/06/30
 */
@Slf4j
@Order(1)
@RequiredArgsConstructor
public class SessionFilter implements Filter {

    private final SessionAdapter sessionAdapter;

    /**
     * true - 输出访问日志<br/>
     * false - 不输出访问日志
     */
    @Value("${yi.boot.rest.sessionFilter.show:true}")
    private boolean show;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        try {
            HttpServletRequest httpServletRequest = (HttpServletRequest) request;
            String uri = httpServletRequest.getRequestURI();
            if (uri.toLowerCase().endsWith(SessionConstants.HTML_SUFFIX)
                    || uri.startsWith(SessionConstants.CGI_PREFIX)) {
                if (show) {
                    log.info("[SessionFilter] {} {}", httpServletRequest.getMethod(), httpServletRequest.getRequestURI());
                }
                Session session = sessionAdapter.getSession((HttpServletRequest) request, true);
                sessionAdapter.setSession((HttpServletResponse) response, session);
                sessionAdapter.storeSession(session);
            }
            chain.doFilter(request, response);
        } finally {
            sessionAdapter.clear();
        }
    }

}
