package com.aishang.asjf.assembly.config.security.filter;

import com.aishang.asjf.common.MyObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Srping Security原登录认证是传统的form表单方式,这里修改为restful JSON方式。
 */
public class RestAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        if (!request.getMethod().equals("POST")) {
            throw new AuthenticationServiceException("Authentication method not supported: " + request.getMethod());
        }

        UsernamePasswordAuthenticationToken authRequest = getUsernamePasswordToken(request);

        // Allow subclasses to set the "details" property
        setDetails(request, authRequest);

        return this.getAuthenticationManager().authenticate(authRequest);
    }

    private UsernamePasswordAuthenticationToken getUsernamePasswordToken(HttpServletRequest request) throws AuthenticationException {
        UsernamePasswordAuthenticationToken token = null;

        try {
            ObjectMapper mapper = MyObjectMapper.getInstance();
            JsonNode jsonObj = mapper.readTree(request.getInputStream());
            String username = jsonObj.get("username").asText();
            String password = jsonObj.get("password").asText();
            token = new UsernamePasswordAuthenticationToken(username, password);
        } catch (Exception e) {
            logger.error("Exception while parsing JSON credentials", e);
            throw new UsernameNotFoundException(e.getLocalizedMessage());
        }

        return token;
    }

}
