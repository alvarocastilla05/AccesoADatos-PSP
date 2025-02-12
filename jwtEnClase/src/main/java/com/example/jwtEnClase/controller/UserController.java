package com.example.jwtEnClase.controller;

import com.example.jwtEnClase.user.dto.CreateUserRequest;
import com.example.jwtEnClase.user.dto.UserResponse;
import com.example.jwtEnClase.user.model.User;
import com.example.jwtEnClase.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/auth/register")
    public ResponseEntity<?> register(@RequestBody CreateUserRequest createUserRequest){
        User user = userService.createUser(createUserRequest);

        return ResponseEntity.status(HttpStatus.CREATED).body(UserResponse.of(user));
    }
}
