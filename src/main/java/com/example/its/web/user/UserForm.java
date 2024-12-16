package com.example.its.web.user;

import com.example.its.domain.auth.UserEntity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

public record UserForm(
        @NotBlank
        String username,

        @NotBlank
        String password
) {
    public UserEntity toEntity() {
        return new UserEntity(username, password);
    }
}
