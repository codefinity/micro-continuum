package com.codefinity.microcontinuum.identityaccess.infrastructure.services;

public class JwtBadSignatureException extends RuntimeException {
    public JwtBadSignatureException(String message) {
        super(message);
    }
}
