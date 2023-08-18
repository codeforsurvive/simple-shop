package com.acn.bootcamp.simpleshop.security;

import com.acn.bootcamp.simpleshop.data.dto.UserDetailDto;
import com.acn.bootcamp.simpleshop.data.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserIdentityService implements UserDetailsService {
    private final UserRepository userRepository;

    @Autowired
    public UserIdentityService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        var user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Username %s is not exists".formatted(username)));
        return new UserDetailDto(user);

    }
}
