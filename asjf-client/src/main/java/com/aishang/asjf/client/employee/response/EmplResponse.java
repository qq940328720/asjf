package com.aishang.asjf.client.employee.response;

import com.aishang.asjf.client.base.CilentBaseResponse;
import com.aishang.asjf.client.employee.response.info.EmployeeInfo;

import java.util.List;

/**
 * Created by mx on 17-11-24.
 */
public class EmplResponse extends CilentBaseResponse {

    private List<EmployeeInfo> rows;

    public List<EmployeeInfo> getRows() {
        return rows;
    }

    public void setRows(List<EmployeeInfo> rows) {
        this.rows = rows;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmplResponse that = (EmplResponse) o;

        return rows != null ? rows.equals(that.rows) : that.rows == null;
    }

    @Override
    public int hashCode() {
        return rows != null ? rows.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "EmplResponse{" +
                "rows=" + rows +
                '}';
    }
}
