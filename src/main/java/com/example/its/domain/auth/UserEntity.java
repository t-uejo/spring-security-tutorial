package com.example.its.domain.auth;

public record UserEntity(
        String username,
        String password,
        Authority authority
) {
    public enum Authority {
        ADMIN,
        USER
    }
}
