package com.aishang.asjf.client.employee.response;

import java.io.Serializable;

/**
 * Created by mx on 17-11-24.
 */
public class EmplResponseWrapper implements Serializable {

    private String employeeCode;
    private String name;
    private String mobileno;

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }

    public String getMobileno() {
        return mobileno;
    }

    public void setMobileno(String mobileno) {
        this.mobileno = mobileno;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmplResponseWrapper that = (EmplResponseWrapper) o;

        if (employeeCode != null ? !employeeCode.equals(that.employeeCode) : that.employeeCode != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        return mobileno != null ? mobileno.equals(that.mobileno) : that.mobileno == null;
    }

    @Override
    public int hashCode() {
        int result = employeeCode != null ? employeeCode.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (mobileno != null ? mobileno.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "EmplResponseWrapper{" +
                "employeeCode='" + employeeCode + '\'' +
                ", name='" + name + '\'' +
                ", mobileno='" + mobileno + '\'' +
                '}';
    }
}
