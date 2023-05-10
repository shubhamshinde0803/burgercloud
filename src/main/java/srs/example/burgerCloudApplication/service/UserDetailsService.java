package srs.example.burgerCloudApplication.service;

import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserDetailsService {
    UserDetails loadUserbyUsername(String username) throws UsernameNotFoundException;


}
