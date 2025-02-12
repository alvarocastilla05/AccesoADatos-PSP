package com.example.jwtEnClase.user.dto;

import com.example.jwtEnClase.user.model.User;

import java.util.UUID;

public record UserResponse(
        UUID id,
        String username) {

    public static UserResponse of(User user) {
        return new UserResponse(user.getId(), user.getUsername());
    }
}

