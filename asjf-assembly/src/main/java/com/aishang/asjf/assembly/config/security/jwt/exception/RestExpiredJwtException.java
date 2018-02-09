package com.aishang.asjf.assembly.config.security.jwt.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * Jwt过期
 */
public class RestExpiredJwtException extends AuthenticationException {
    public RestExpiredJwtException(String msg) {
        super(msg);
    }
}
