package com.codefinity.microcontinuum.identityaccess.infrastructure.services;

public class MalformedJwtException extends RuntimeException {
    public MalformedJwtException(String message) {
        super(message);
    }
}
