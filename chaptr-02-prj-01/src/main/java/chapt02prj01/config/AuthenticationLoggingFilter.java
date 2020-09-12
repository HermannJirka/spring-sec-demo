package chapt02prj01.config;

import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

public class AuthenticationLoggingFilter extends OncePerRequestFilter {

    private final Logger logger = Logger.getLogger(chapt02prj01.config.AuthenticationLoggingFilter.class.getName());


    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {

        String requestId = httpServletRequest.getHeader("Request-id");

        logger.info("Authentication was sucessfully request with id " + requestId);

        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}
