package com.aishang.asjf.assembly.config.security.jwt.exception;

import org.springframework.security.core.AuthenticationException;

public class RestMissingClaimException extends AuthenticationException {
    public RestMissingClaimException(String msg) {
        super(msg);
    }
}
