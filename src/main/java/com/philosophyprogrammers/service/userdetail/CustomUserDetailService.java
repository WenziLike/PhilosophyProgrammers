package com.philosophyprogrammers.service.userdetail;

import com.philosophyprogrammers.entity.UserEntity;
import com.philosophyprogrammers.repository.UserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 *
 *
 * @author Viacheslav Murakhin
 * @version 1.0
 */

@Service("userDetailsService")
@Transactional
public class CustomUserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity userCustomer = userRepository.findByEmail(email);

        if (userCustomer == null) {
            throw new UsernameNotFoundException(email);
        }

        UserDetails user = User.withUsername(userCustomer.getEmail())
                .password(userCustomer.getPassword())
                .username(String.valueOf(userCustomer.setActive(true)))
                .authorities("ROLE_USER").build();
        return user;
    }
}
