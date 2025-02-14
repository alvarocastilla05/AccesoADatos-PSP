package com.salesianostriana.dam.jwt.security.security.jwt.refresh;

import com.salesianostriana.dam.jwt.security.security.jwt.access.JwtService;
import com.salesianostriana.dam.jwt.security.user.dto.UserResponse;
import com.salesianostriana.dam.jwt.security.user.model.User;
import com.salesianostriana.dam.jwt.security.user.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional(readOnly=true)
public class RefreshTokenService {

    private final RefreshTokenRepository refreshTokenRepository;
    private final UserRepository userRepository;
    private final JwtService jwtService;

    @Value("${jwt.refresh.duration}")
    private int durationInMinutes;

    @Transactional
    public RefreshToken create(User user) {
        //User u = userRepository.findById(user.getId()).orElse(null);
        return refreshTokenRepository.save(
          RefreshToken.builder()
                  .user(user)
                  //.user(u)
                  //.token(UUID.randomUUID().toString())
                  .expireAt(Instant.now().plusSeconds(durationInMinutes*60))
                  .build()
        );
    }

    @Transactional
    public RefreshToken verify(RefreshToken refreshToken){
        if(refreshToken.getExpireAt().compareTo(Instant.now()) < 0){
            //Token de refresco cadudaco.
            //Borrar token
            refreshTokenRepository.delete(refreshToken);
            throw new RefreshTokenException("Token de refresco caducado. Por favor, vuelva a iniciar sesión.");
        }

        return refreshToken;
    }

    public UserResponse refreshToken(String token) {

        return refreshTokenRepository.findById(UUID.fromString(token))
                .map(this::verify)
                .map(RefreshToken::getUser)
                .map(user -> {
                    String accessToken = jwtService.generateAccessToken(user);
                    RefreshToken refreshedToken = this.create(user);
                    return UserResponse.of(user, accessToken, refreshedToken.getToken());
                })
                .orElseThrow(() -> new RefreshTokenException("No se ha podido refrescar el token. Por favor, vuelva a loguearse"));

    }


}
