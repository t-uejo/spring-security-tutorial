package com.example.its.domain.auth;


import org.springframework.security.core.CredentialsContainer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class CustomUserDetails extends User {

    public CustomUserDetails(
            String username,
            String password,
            Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }
}
