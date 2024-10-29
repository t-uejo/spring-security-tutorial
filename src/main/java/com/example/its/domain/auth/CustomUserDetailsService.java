package com.example.its.domain.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //TODO:権限の実装
        return userRepository.findByUsername(username)
                .map(user ->
                        new CustomUserDetails(user.username(), user.password(), Collections.emptyList())
                )
                .orElseThrow(() ->
                        new UsernameNotFoundException("Given username is not found. " + username)
                );
    }
}
