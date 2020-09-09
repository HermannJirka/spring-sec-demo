package chapt02prj01.config;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

public class AuthenticationLoggingFilter implements Filter {

    private final Logger logger = Logger.getLogger(AuthenticationLoggingFilter.class.getName());

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        var httpRequest = (HttpServletRequest) servletRequest;

        String requestId = httpRequest.getHeader("Request-id");

        logger.info("Authentication was sucessfully request with id "+ requestId);

        filterChain.doFilter(servletRequest, servletResponse);
    }
}
