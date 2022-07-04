package org.burgeon.yi.boot.rest.session.filter;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.burgeon.yi.boot.rest.session.Session;
import org.burgeon.yi.boot.rest.session.SessionAdapter;
import org.burgeon.yi.boot.rest.session.SessionConstants;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author Sam Lu
 * @date 2022/06/30
 */
@Slf4j
@Order(1)
@RequiredArgsConstructor
public class SessionPrevFilter implements Filter {

    private final SessionAdapter sessionAdapter;

    /**
     * true - 输出静态资源的访问日志<br/>
     * false - 不输出静态资源的访问日志
     */
    @Value("${yi.boot.rest.staticResources.show:true}")
    private boolean show;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String uri = httpServletRequest.getRequestURI();
        if (uri.toLowerCase().endsWith(SessionConstants.HTML_SUFFIX)) {
            if (show) {
                log.info("{} {}", httpServletRequest.getMethod(), httpServletRequest.getRequestURI());
            }
            Session session = sessionAdapter.getSession((HttpServletRequest) request, true);
            session.checkCsrfToken();
        }
        chain.doFilter(request, response);
    }

}
