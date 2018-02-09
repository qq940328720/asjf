package com.aishang.asjf.assembly.config.security.jwt.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * Jwt未生效前被使用
 */
public class RestPrematureJwtException extends AuthenticationException {
    public RestPrematureJwtException(String msg) {
        super(msg);
    }
}
