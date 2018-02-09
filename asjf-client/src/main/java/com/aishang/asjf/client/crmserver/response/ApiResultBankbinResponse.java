package com.aishang.asjf.client.crmserver.response;


import com.aishang.asjf.client.base.CilentBaseResponse;

import java.util.List;

public class ApiResultBankbinResponse extends CilentBaseResponse {

    private static final long serialVersionUID = 1L;

    private List<ApiResultBankbinInfoResponse> resultDatas;

    public List<ApiResultBankbinInfoResponse> getResultDatas() {
        return resultDatas;
    }

    public void setResultDatas(List<ApiResultBankbinInfoResponse> resultDatas) {
        this.resultDatas = resultDatas;
    }
}
