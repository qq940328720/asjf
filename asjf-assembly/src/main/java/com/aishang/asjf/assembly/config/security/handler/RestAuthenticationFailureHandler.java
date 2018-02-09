package com.aishang.asjf.assembly.config.security.handler;


import com.aishang.asjf.common.MyObjectMapper;
import com.aishang.asjf.common.enums.ErrorCode;
import com.aishang.asjf.facade.dto.response.base.ResponseDTOWrapper;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by neeke on 17-9-12.
 * 处理登录认证失败
 */
@Component
public class RestAuthenticationFailureHandler implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        httpServletResponse.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        MyObjectMapper.getInstance().writeValue(httpServletResponse.getOutputStream(), new ResponseDTOWrapper(ErrorCode.USERNAME_OR_PASSWORD_ERROR.getCode(), ErrorCode.USERNAME_OR_PASSWORD_ERROR.getMessage()));
    }
}
