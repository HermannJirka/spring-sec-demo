package chapt02prj01.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public class InMemoryUserService implements UserDetailsService {

    private final List<UserDetails> userDetails;

    public InMemoryUserService(List<UserDetails> userDetails) {
        this.userDetails = userDetails;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return userDetails.stream()
                .filter(u -> u.getUsername().equals(s))
                .findFirst()
                .orElseThrow(()-> new UsernameNotFoundException("User not found"));
    }
}
