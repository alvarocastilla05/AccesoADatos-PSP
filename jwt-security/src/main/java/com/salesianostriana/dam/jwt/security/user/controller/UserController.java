package com.salesianostriana.dam.jwt.security.user.controller;

import com.salesianostriana.dam.jwt.security.security.exceptionhandling.JwtException;
import com.salesianostriana.dam.jwt.security.security.jwt.access.JwtService;
import com.salesianostriana.dam.jwt.security.security.jwt.refresh.RefreshToken;
import com.salesianostriana.dam.jwt.security.security.jwt.refresh.RefreshTokenRequest;
import com.salesianostriana.dam.jwt.security.security.jwt.refresh.RefreshTokenService;
import com.salesianostriana.dam.jwt.security.security.jwt.verification.OnRegistrationCompleteEvent;
import com.salesianostriana.dam.jwt.security.user.dto.CreateUserRequest;
import com.salesianostriana.dam.jwt.security.user.dto.LoginRequest;
import com.salesianostriana.dam.jwt.security.user.dto.UserResponse;
import com.salesianostriana.dam.jwt.security.user.model.User;
import com.salesianostriana.dam.jwt.security.user.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final RefreshTokenService refreshTokenService;
    private final ApplicationEventPublisher eventPublisher;

    @PostMapping("/auth/register")
    public ResponseEntity<UserResponse> register(@RequestBody CreateUserRequest createUserRequest) {
        User user = userService.createUser(createUserRequest);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(UserResponse.of(user));
    }

    @PostMapping("/auth/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {


        Authentication authentication =
                authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.username(),
                        loginRequest.password()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        User user = (User) authentication.getPrincipal();

        String accessToken = jwtService.generateAccessToken(user);

        // Generar el token de refresco
        RefreshToken refreshToken = refreshTokenService.create(user);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(UserResponse.of(user, accessToken, refreshToken.getToken()));

    }

    @GetMapping("/auth/refresh/token")
    public ResponseEntity<?> refreshToken(@RequestBody RefreshTokenRequest req){
        String token = req.refreshToken();

        //Validar token.
        //Obtener el usuario asociado al token de refresco.
        //Generar un nuevo token de acceso.
        //Generar un nuevo token de refresco.

        return ResponseEntity.status(HttpStatus.CREATED).body(refreshTokenService.refreshToken(token));
    }

    @GetMapping("/me")
    public UserResponse me(@AuthenticationPrincipal User user) {
        return UserResponse.of(user);
    }

    @GetMapping("/me/admin")
    public User adminMe(@AuthenticationPrincipal User user) {
        return user;
    }

    @PostMapping("/user/registration")
    public ModelAndView registerUserAccount(@ModelAttribute("user") CreateUserRequest user, HttpServletRequest request, Errors errors){

        try {
            User registered = userService.createUser(user);

            String appUrl = request.getContextPath();
            eventPublisher.publishEvent(new OnRegistrationCompleteEvent(registered, request.getLocale(), appUrl));
        }catch (JwtException ex){
            ModelAndView mav = new ModelAndView("registration", "user", user);
            mav.addObject("message", "An account for that username/email already exist");
            return mav;
        }catch (RuntimeException ex){
            return new ModelAndView("emailError", "user", user);
        }

        return new ModelAndView("successRegister", "user", user);
    }



}



