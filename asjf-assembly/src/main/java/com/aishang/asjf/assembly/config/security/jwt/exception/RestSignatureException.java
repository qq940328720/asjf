package com.aishang.asjf.assembly.config.security.jwt.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * 签名异常
 */
public class RestSignatureException extends AuthenticationException {
    public RestSignatureException(String message) {
        super(message);
    }
}
