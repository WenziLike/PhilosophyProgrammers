package com.philosophyprogrammers.security.userdetail;

import com.philosophyprogrammers.entity.GroupEntity;
import com.philosophyprogrammers.entity.UserEntity;
import com.philosophyprogrammers.repository.UserRepository;
import org.hibernate.FetchMode;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

/**
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
        UserEntity customer = userRepository.findByEmail(email);

        if (customer == null) {
            throw new UsernameNotFoundException(email);
        }

        UserDetails user = User.withUsername(customer.getUsername())
                .password(customer.getPassword())
                .authorities(getAuthorities(customer)).build();
        return user;
    }

    private Collection<GrantedAuthority> getAuthorities(UserEntity user) {
        Set<GroupEntity> userGroups = user.getUserGroups();
        Collection<GrantedAuthority> authorities = new ArrayList<>(userGroups.size());
        for (GroupEntity userGroup : userGroups) {
            authorities.add(new SimpleGrantedAuthority(userGroup.getCode().toUpperCase()));
        }

        return authorities;
    }
}
