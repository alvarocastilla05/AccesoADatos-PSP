package com.example.jwtEnClase.security.jwt.access;

import io.jsonwebtoken.JwtParser;
import lombok.Value;
import org.springframework.stereotype.Service;

@Service
public class JwtService {

    public static final String TOKE_TYPE = "JWT";
    public static final String TOKEN_HEADER = "Authorization";
    public static final String TOKEN_PERFIX = "Bearer";

    @Value("${jwt.secret}")
    private String jwtSecret;

    @Value("${jwt.duration}")
    private long jwtLifeInMinutes;

    private JwtParser jwtParser;


}
