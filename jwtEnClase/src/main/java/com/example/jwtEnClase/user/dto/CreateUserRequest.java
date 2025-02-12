package com.example.jwtEnClase.user.dto;

public record CreateUserRequest(
        String username,
        String password,
        String verifyPassword
) {
}
