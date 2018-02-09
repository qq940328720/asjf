package com.aishang.asjf.web.controller.base;

import com.aishang.asjf.common.enums.ErrorCode;
import com.aishang.asjf.facade.dto.response.base.ResponseDTOWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * Created by neeke on 17-9-9.
 */
public abstract class BaseController {

    protected final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    protected ResponseDTOWrapper createResponse(Object data) {
        ResponseDTOWrapper responseDTOWrapper = createResponse();
        responseDTOWrapper.setData(data);
        return responseDTOWrapper;
    }

    protected ResponseDTOWrapper createResponse(ErrorCode errorCode) {
        ResponseDTOWrapper responseDTOWrapper = createResponse();
        responseDTOWrapper.setCode(errorCode.getCode());
        responseDTOWrapper.setMessage(errorCode.getMessage());
        return responseDTOWrapper;
    }

    protected ResponseDTOWrapper createResponse(ErrorCode errorCode,String custMsg) {
        ResponseDTOWrapper responseDTOWrapper = createResponse();
        responseDTOWrapper.setCode(errorCode.getCode());
        responseDTOWrapper.setMessage(String.format(errorCode.getMessage(), custMsg));
        return responseDTOWrapper;
    }

    protected ResponseDTOWrapper createResponse() {
        ResponseDTOWrapper responseDTOWrapper = new ResponseDTOWrapper();
        responseDTOWrapper.setCode(ErrorCode.OK.getCode());
        responseDTOWrapper.setMessage(ErrorCode.OK.getMessage());
        return responseDTOWrapper;
    }

    protected ResponseDTOWrapper createResponse(Object data, Long totalCount) {
        ResponseDTOWrapper responseDTOWrapper = createResponse(data);
        responseDTOWrapper.setTotalCount(totalCount);
        return responseDTOWrapper;
    }

    //获得userCode
    public static String getuserCode() {
        Object account = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return account.toString();
    }
}
