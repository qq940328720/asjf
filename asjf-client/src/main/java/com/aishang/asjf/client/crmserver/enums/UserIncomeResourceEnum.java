package com.aishang.asjf.client.crmserver.enums;

import java.util.HashMap;
import java.util.Map;

public enum UserIncomeResourceEnum {
    SALARY((byte) 1, "工资收入"),
    OPERATING((byte) 2, "营业收入"),
    PROPERTY((byte) 3, "财产收入"),
    OTHER((byte) 4, "其他收入");
    private static Map<Byte, UserIncomeResourceEnum> valueMap;

    static {
        valueMap = new HashMap();
        for (UserIncomeResourceEnum e : values())
            valueMap.put(e.status, e);
    }

    private final Byte status;
    private final String displayName;

    UserIncomeResourceEnum(Byte status, String displayName) {
        this.status = status;
        this.displayName = displayName;
    }

    public static UserIncomeResourceEnum getEnum(Byte key) {
        if (!valueMap.containsKey(key)) {
            return null;
        }
        return valueMap.get(key);
    }

    public Byte getValue() {
        return this.status;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public Map<Byte, UserIncomeResourceEnum> getAllValueMap() {
        return valueMap;
    }

    public String getEnumName() {
        return this.name();
    }
}
