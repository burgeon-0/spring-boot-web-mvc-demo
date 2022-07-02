package org.burgeon.yi.basic.user.adapter.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.regex.Pattern;

/**
 * @author Sam Lu
 * @date 2022/06/30
 */
@Slf4j
@Component
@Order(1)
public class StaticFilter implements Filter {

    private Pattern includeUriPattern = Pattern.compile("^/\\w+(/\\w+)*\\.html$");

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String uri = httpServletRequest.getRequestURI();
        if (includeUriPattern.matcher(uri).find()) {
            log.info("{} {}", httpServletRequest.getMethod(), httpServletRequest.getRequestURI());
        }
        chain.doFilter(request, response);
    }

}
