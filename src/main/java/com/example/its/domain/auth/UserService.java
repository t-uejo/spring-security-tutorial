package com.example.its.domain.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    public List<UserEntity> findAll(){
        return userRepository.findAll();
    }

    @Transactional
    public void create(UserEntity entity) {
        userRepository.create(entity.username(), entity.password());
    }
}
