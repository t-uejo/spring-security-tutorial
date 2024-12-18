package com.example.its.web.user;

import com.example.its.domain.auth.UserEntity;
import com.example.its.web.validation.UniqueUsername;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

public record UserForm(
        @NotBlank
        @UniqueUsername
        String username,

        @NotBlank
        @Size(min = 12, max = 128)
        String password,

        @Pattern(regexp="ADMIN|USER", message = "いずれかの権限を選択してください")
        String authority
) {

    public UserEntity toEntity() {
        return new UserEntity(
                username(),
                password(),
                UserEntity.Authority.valueOf(authority())
        );
    }
}
