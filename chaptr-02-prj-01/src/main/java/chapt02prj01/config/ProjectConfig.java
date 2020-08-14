package chapt02prj01.config;

import chapt02prj01.domain.DummyUser;
import chapt02prj01.service.InMemoryUserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.List;

@Configuration
public class ProjectConfig {
    @Bean
    public UserDetailsService userDetailsService(){
        var user = new DummyUser("jirka","1234","read");
        List<UserDetails> users = List.of(user);
        return new InMemoryUserService(users);
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }

}
