package com.aishang.asjf.assembly.config.security.jwt.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * 类型不匹配
 */
public class RestRequiredTypeException extends AuthenticationException {

    public RestRequiredTypeException(String msg) {
        super(msg);
    }
}
