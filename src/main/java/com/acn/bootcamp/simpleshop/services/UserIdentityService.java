package com.acn.bootcamp.simpleshop.services;

import com.acn.bootcamp.simpleshop.data.dto.UserDetail;
import com.acn.bootcamp.simpleshop.data.repositories.ResourceAccessControlRepository;
import com.acn.bootcamp.simpleshop.data.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserIdentityService implements UserDetailsService {
    private final UserRepository userRepository;
    private final ResourceAccessControlRepository aclRepository;

    @Autowired
    public UserIdentityService(UserRepository userRepository, ResourceAccessControlRepository aclRepository) {
        this.userRepository = userRepository;
        this.aclRepository = aclRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        final var user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Username %s is not exists".formatted(username)));
        final var acl = aclRepository.findByRole(user.getRole());
        return new UserDetail(user, acl);

    }
}
