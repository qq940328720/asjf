package com.aishang.asjf.client.crmserver.enums;


import java.util.Map;

public enum DataCompletionEnum {
    BASE(2, "1", 30),
    WORk(4, "2", 30),
    CONTACT(8, "3", 30),
    BANK(16, "4", 10);
    private Integer status;
    private String displayName;
    private int value;

    private static Map<Integer, DataCompletionEnum> valueMap;

    DataCompletionEnum(Integer status, String displayName, int value) {
        this.status = status;
        this.displayName = displayName;
        this.value = value;
    }

    public Integer getStatus() {
        return status;
    }

    public String getDisplayName() {
        return displayName;
    }

    public int getValue() {
        return value;
    }


}
