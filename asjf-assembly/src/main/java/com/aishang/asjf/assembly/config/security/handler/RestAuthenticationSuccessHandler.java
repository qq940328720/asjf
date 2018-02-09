package com.aishang.asjf.assembly.config.security.handler;


import com.aishang.asjf.common.JwtTokenUtil;
import com.aishang.asjf.common.MyObjectMapper;
import com.aishang.asjf.common.enums.ErrorCode;
import com.aishang.asjf.facade.dto.response.base.ResponseDTOWrapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;

/**
 * Created by neeke on 17-9-12.
 * 处理登录认证成功
 */
@Component
public class RestAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    /**
     * 登录认证后生成accessToken
     *
     * @param httpServletRequest
     * @param httpServletResponse
     * @param authentication
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        String token = jwtTokenUtil.generateToken((UserDetails) authentication.getPrincipal());
        httpServletResponse.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        MyObjectMapper.getInstance().writeValue(httpServletResponse.getOutputStream(), new ResponseDTOWrapper(Collections.singletonMap("accessToken", token), ErrorCode.OK.getCode(), ErrorCode.OK.getMessage()));

    }
}
