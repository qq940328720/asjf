package com.aishang.asjf.client.apiserver.response.info;

import java.io.Serializable;

/**
 * Created by mx on 17-12-9.
 */

public class BankInfo implements Serializable {

    private String dataCode;
    private String dataType;
    private String dataName;
    private String dataValue;
    private String dataRemark;
    private String createUserId;
    private Long insertTime;
    private Long updateTime;
    private String bizid;

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

    public String getDataRemark() {
        return dataRemark;
    }

    public void setDataRemark(String dataRemark) {
        this.dataRemark = dataRemark;
    }

    public String getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }

    public Long getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(Long insertTime) {
        this.insertTime = insertTime;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    public String getBizid() {
        return bizid;
    }

    public void setBizid(String bizid) {
        this.bizid = bizid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BankInfo bankInfo = (BankInfo) o;

        if (dataCode != null ? !dataCode.equals(bankInfo.dataCode) : bankInfo.dataCode != null) return false;
        if (dataType != null ? !dataType.equals(bankInfo.dataType) : bankInfo.dataType != null) return false;
        if (dataName != null ? !dataName.equals(bankInfo.dataName) : bankInfo.dataName != null) return false;
        if (dataValue != null ? !dataValue.equals(bankInfo.dataValue) : bankInfo.dataValue != null) return false;
        if (dataRemark != null ? !dataRemark.equals(bankInfo.dataRemark) : bankInfo.dataRemark != null) return false;
        if (createUserId != null ? !createUserId.equals(bankInfo.createUserId) : bankInfo.createUserId != null)
            return false;
        if (insertTime != null ? !insertTime.equals(bankInfo.insertTime) : bankInfo.insertTime != null) return false;
        if (updateTime != null ? !updateTime.equals(bankInfo.updateTime) : bankInfo.updateTime != null) return false;
        return bizid != null ? bizid.equals(bankInfo.bizid) : bankInfo.bizid == null;
    }

    @Override
    public int hashCode() {
        int result = dataCode != null ? dataCode.hashCode() : 0;
        result = 31 * result + (dataType != null ? dataType.hashCode() : 0);
        result = 31 * result + (dataName != null ? dataName.hashCode() : 0);
        result = 31 * result + (dataValue != null ? dataValue.hashCode() : 0);
        result = 31 * result + (dataRemark != null ? dataRemark.hashCode() : 0);
        result = 31 * result + (createUserId != null ? createUserId.hashCode() : 0);
        result = 31 * result + (insertTime != null ? insertTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        result = 31 * result + (bizid != null ? bizid.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "BankInfo{" +
                "dataCode='" + dataCode + '\'' +
                ", dataType='" + dataType + '\'' +
                ", dataName='" + dataName + '\'' +
                ", dataValue='" + dataValue + '\'' +
                ", dataRemark='" + dataRemark + '\'' +
                ", createUserId='" + createUserId + '\'' +
                ", insertTime=" + insertTime +
                ", updateTime=" + updateTime +
                ", bizid='" + bizid + '\'' +
                '}';
    }
}
