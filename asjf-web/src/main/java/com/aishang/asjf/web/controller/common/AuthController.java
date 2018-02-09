package com.aishang.asjf.web.controller.common;

import com.aishang.asjf.facade.dto.request.auth.AuthDTO;
import com.aishang.asjf.facade.dto.response.base.ResponseDTOWrapper;
import com.aishang.asjf.web.controller.base.BaseController;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

//@RestController
//@RequestMapping("auth/v1")
//@Api(description = "身份认证")
public class AuthController extends BaseController {

    @PostMapping
    @ApiOperation(value = "身份认证", response = ResponseDTOWrapper.class)
    public ResponseDTOWrapper send(@RequestBody AuthDTO authDTO) throws Exception {
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(authDTO.getAccount(), authDTO.getPassword());
        SecurityContextHolder.getContext().setAuthentication(token);
        return createResponse();
    }
}
