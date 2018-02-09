package com.aishang.asjf.client.crmserver.response.info;

/**
 * Created by mx on 17-12-9.
 */
public class DicBankInfo {
    private String dataName;
    private String dataValue;
    private String dataCode;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DicBankInfo that = (DicBankInfo) o;

        if (dataName != null ? !dataName.equals(that.dataName) : that.dataName != null) return false;
        if (dataValue != null ? !dataValue.equals(that.dataValue) : that.dataValue != null) return false;
        return dataCode != null ? dataCode.equals(that.dataCode) : that.dataCode == null;
    }

    @Override
    public int hashCode() {
        int result = dataName != null ? dataName.hashCode() : 0;
        result = 31 * result + (dataValue != null ? dataValue.hashCode() : 0);
        result = 31 * result + (dataCode != null ? dataCode.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "DicBankInfo{" +
                "dataName='" + dataName + '\'' +
                ", dataValue='" + dataValue + '\'' +
                ", dataCode='" + dataCode + '\'' +
                '}';
    }
}
