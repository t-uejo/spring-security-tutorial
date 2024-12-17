package com.example.its.domain.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    @Transactional(readOnly = true)
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<UserEntity> findAll(){
        return userRepository.findAll();
    }

    @Transactional
    public void create(UserEntity entity) {
        var encodedPassword = passwordEncoder.encode(entity.password());
        userRepository.create(entity.username(), encodedPassword, entity.authority().name());
    }
}
