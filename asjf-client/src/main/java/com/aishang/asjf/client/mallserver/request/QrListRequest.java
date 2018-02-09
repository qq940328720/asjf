package com.aishang.asjf.client.mallserver.request;

import com.aishang.asjf.client.base.ClientBaseRequestParameters;

/**
 * Created by mx on 17-11-25.
 */
public class QrListRequest extends ClientBaseRequestParameters {

    private String employeeCode;

    private String mallName;

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getMallName() {
        return mallName;
    }

    public void setMallName(String mallName) {
        this.mallName = mallName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        QrListRequest that = (QrListRequest) o;

        if (employeeCode != null ? !employeeCode.equals(that.employeeCode) : that.employeeCode != null) return false;
        return mallName != null ? mallName.equals(that.mallName) : that.mallName == null;
    }

    @Override
    public int hashCode() {
        int result = employeeCode != null ? employeeCode.hashCode() : 0;
        result = 31 * result + (mallName != null ? mallName.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "QrListRequest{" +
                "employeeCode='" + employeeCode + '\'' +
                ", mallName='" + mallName + '\'' +
                '}';
    }
}
