package cz.tut.sec.demo;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        var authorities = authentication.getAuthorities();

        Optional<? extends GrantedAuthority> auth = authorities.stream()
                .filter(a -> a.getAuthority().equals("read"))
                .findFirst();

        if(auth.isPresent()){
            httpServletResponse.sendRedirect("/home");
        }else{
            httpServletResponse.sendRedirect("/home");
        }

    }
}
