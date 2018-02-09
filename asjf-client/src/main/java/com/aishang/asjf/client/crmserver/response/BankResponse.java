package com.aishang.asjf.client.crmserver.response;

import com.aishang.asjf.client.base.CilentBaseResponse;

import java.util.Date;

/**
 * 支持银行列表的实体信息
 * Created by whb on 17-12-24.
 */
public class BankResponse extends CilentBaseResponse {

    private String dataName;

    private String dataValue;

    private String dataCode;

    private String dataType;

    private String dataReark;


    @Override
    public String toString() {
        return "BankResponse{" +
                "dataName='" + dataName + '\'' +
                ", dataValue='" + dataValue + '\'' +
                ", dataCode='" + dataCode + '\'' +
                ", dataType='" + dataType + '\'' +
                ", dataReark='" + dataReark + '\'' +
                '}';
    }

    public String getDataName() {
        return dataName;
    }

    public void setDataName(String dataName) {
        this.dataName = dataName;
    }

    public String getDataValue() {
        return dataValue;
    }

    public void setDataValue(String dataValue) {
        this.dataValue = dataValue;
    }

    public String getDataCode() {
        return dataCode;
    }

    public void setDataCode(String dataCode) {
        this.dataCode = dataCode;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getDataReark() {
        return dataReark;
    }

    public void setDataReark(String dataReark) {
        this.dataReark = dataReark;
    }
}
