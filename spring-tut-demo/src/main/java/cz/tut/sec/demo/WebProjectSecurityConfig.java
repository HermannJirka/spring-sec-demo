package cz.tut.sec.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class WebProjectSecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomAuthenticationFailureHandler authenticationFailureHandler;
    private final CustomAuthenticationSuccessHandler authenticationSuccessHandler;

    public WebProjectSecurityConfig(CustomAuthenticationFailureHandler authenticationFailureHandler, CustomAuthenticationSuccessHandler authenticationSuccessHandler) {
        this.authenticationFailureHandler = authenticationFailureHandler;
        this.authenticationSuccessHandler = authenticationSuccessHandler;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin().successHandler(authenticationSuccessHandler)
                .failureHandler(authenticationFailureHandler)
                .and().httpBasic();
        http.authorizeRequests().anyRequest().authenticated();
    }
}
