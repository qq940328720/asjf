package com.aishang.asjf.common.enums;

/**
 * 用户类型
 */
public enum UserType {

    //客户
    CUSTOMER("cust"),
    //业务员
    EMPLOYEE("empl");

    private String value;

    UserType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
