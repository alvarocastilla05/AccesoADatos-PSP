package com.example.jjwt.security.jwt.refresh;

import com.example.jjwt.security.errorhandling.JwtTokenException;

public class RefreshTokenException extends JwtTokenException {

    public RefreshTokenException(String msg) {
        super(msg);
    }
}
