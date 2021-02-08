package springsecuritychapter06app.securewebapp.service;

import lombok.val;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import springsecuritychapter06app.securewebapp.repository.UserRepository;
import springsecuritychapter06app.securewebapp.security.CustomUserDetails;

import java.util.function.Supplier;

@Service
public class JpaUserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    public JpaUserDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public CustomUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Supplier<UsernameNotFoundException> s = () -> new UsernameNotFoundException("Problem with authentication!!!");
        val user = userRepository.findUserByUsername(username).orElseThrow(s);
        return new CustomUserDetails(user);
    }
}
