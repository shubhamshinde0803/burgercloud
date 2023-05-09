package srs.example.burgerCloudApplication.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import srs.example.burgerCloudApplication.data.UserRepository;
import srs.example.burgerCloudApplication.domain.User;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService{


    private final UserRepository userRepo;


    @Override
    public UserDetails loadUserbyUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(username);
        if(user!=null)
            return user;
        throw new UsernameNotFoundException("User " + username + " not found");
    }

}
