package com.codefinity.microcontinuum.identityaccess.infrastructure.services;

public class JwtExpirationException extends RuntimeException {
    public JwtExpirationException(String message) {
        super(message);
    }
}
