package chapt02prj01.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class ProjectConfig {

    @Bean
    public UserDetailsService userDetailsService() {
        var manager = new InMemoryUserDetailsManager();

        var usr1 = User.withUsername("jirka")
                .password("1234")
                .roles("ADMIN")
                .build();
        var usr2 = User.withUsername("pepa")
                .password("1234")
                .roles("MANAGER")
                .build();
        var usr3 = User.withUsername("Jarda")
                .password("1234")
                .roles("USER")
                .build();

        manager.createUser(usr1);
        manager.createUser(usr2);
        manager.createUser(usr3);
        return manager;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
