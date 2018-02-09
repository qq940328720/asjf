package com.aishang.asjf.client.crmserver.response;

import com.aishang.asjf.client.base.CilentBaseResponse;

import java.util.Date;
import java.util.List;

/**
 * 支持银行列表的实体信息
 * Created by whb on 17-12-24.
 */
public class BankListResponse extends CilentBaseResponse {

    private List<BankResponse> resultData;


    @Override
    public String toString() {
        return "BankListResponse{" +
                "resultData=" + resultData +
                '}';
    }

    public List<BankResponse> getResultData() {
        return resultData;
    }

    public void setResultData(List<BankResponse> resultData) {
        this.resultData = resultData;
    }
}
