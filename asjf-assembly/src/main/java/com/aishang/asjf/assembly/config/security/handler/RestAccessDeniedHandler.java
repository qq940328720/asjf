package com.aishang.asjf.assembly.config.security.handler;


import com.aishang.asjf.common.MyObjectMapper;
import com.aishang.asjf.common.enums.ErrorCode;
import com.aishang.asjf.facade.dto.response.base.ResponseDTOWrapper;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by neeke on 17-9-12.
 * 处理拒绝访问
 */
@Component
public class RestAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException {

        MyObjectMapper.getInstance().writeValue(httpServletResponse.getOutputStream(), new ResponseDTOWrapper(ErrorCode.ACCESS_DENIED.getCode(), ErrorCode.ACCESS_DENIED.getMessage()));
    }
}
