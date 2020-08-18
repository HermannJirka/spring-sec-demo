package chapt02prj01.service;

import chapt02prj01.domain.User;
import chapt02prj01.repository.UserRepository;
import chapt02prj01.security.CustomUserDetails;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.function.Supplier;

@Service
public class JpaDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public JpaDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Supplier<UsernameNotFoundException> s =
                () -> new UsernameNotFoundException("Problem during authentication");

        User user = userRepository.findByUsername(username)
                .orElseThrow(s);
        return new CustomUserDetails(user);
    }
}
