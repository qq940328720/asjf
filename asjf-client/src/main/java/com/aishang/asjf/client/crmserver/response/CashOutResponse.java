package com.aishang.asjf.client.crmserver.response;

import com.aishang.asjf.client.base.CilentBaseResponse;

import java.io.Serializable;

public class CashOutResponse implements Serializable {

    private String pageUrl;

    private  String custmerId;

    @Override
    public String toString() {
        return "CustUrlResponse{" +
                "pageUrl='" + pageUrl + '\'' +
                ", custmerId='" + custmerId + '\'' +
                '}';
    }

    public String getPageUrl() {
        return pageUrl;
    }

    public void setPageUrl(String pageUrl) {
        this.pageUrl = pageUrl;
    }

    public String getCustmerId() {
        return custmerId;
    }

    public void setCustmerId(String custmerId) {
        this.custmerId = custmerId;
    }
}