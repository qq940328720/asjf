package com.aishang.asjf.client.orderserver.response;

import com.aishang.asjf.client.base.CilentBaseResponse;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by whb on 18-01-18.
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY )
public class AppPayPlanResponse {

    private List<AppPayPlanInfoResponse> appPayPlanInfoResponseList;//还款期数

    @Override
    public String toString() {
        return "AppPayPlanResponse{" +
                "appPayPlanInfoResponseList=" + appPayPlanInfoResponseList +
                '}';
    }

    public List<AppPayPlanInfoResponse> getAppPayPlanInfoResponseList() {
        return appPayPlanInfoResponseList;
    }

    public void setAppPayPlanInfoResponseList(List<AppPayPlanInfoResponse> appPayPlanInfoResponseList) {
        this.appPayPlanInfoResponseList = appPayPlanInfoResponseList;
    }
}
