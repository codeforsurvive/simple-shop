package com.acn.bootcamp.simpleshop.data.dto;

import com.acn.bootcamp.simpleshop.data.domain.ResourceAccessControl;
import com.acn.bootcamp.simpleshop.data.domain.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;
import java.util.stream.Collectors;

public class UserDetail implements UserDetails {
    private final User user;
    private final Set<ResourceAccessControl> acls;
    public UserDetail(User user, List<ResourceAccessControl> acls) {
        this.user = user;
        this.acls = new HashSet<>(acls);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return acls.stream()
                .map(acl -> String.format("%s_%s", acl.getResourceGroup(), acl.getAccessLevel()))
                .map(authority -> new SimpleGrantedAuthority(authority) )
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
