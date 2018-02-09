package com.aishang.asjf.assembly.config.security.jwt.exception;


import org.springframework.security.core.AuthenticationException;

/**
 * Jwt格式错误
 */
public class RestMalformedJwtException extends AuthenticationException {
    public RestMalformedJwtException(String msg) {
        super(msg);
    }
}
