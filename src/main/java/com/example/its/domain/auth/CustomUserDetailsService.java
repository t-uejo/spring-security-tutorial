package com.example.its.domain.auth;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //TODO:仮実装
        if ("tom".equals(username)) {
            return new CustomUserDetails(username, "password", Collections.emptyList());
        }
        throw new UsernameNotFoundException("Given username is not found. " + username);
    }
}
