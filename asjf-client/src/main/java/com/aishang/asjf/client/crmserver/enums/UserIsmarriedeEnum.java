package com.aishang.asjf.client.crmserver.enums;

import java.util.HashMap;
import java.util.Map;

public enum UserIsmarriedeEnum {
    UNMARRIED((byte) 1, "未婚"),
    MARRIED((byte) 2, "已婚"),
    FIRST_MARRIAGE((byte) 3, "初婚");

    private final Byte status;
    private final String displayName;
    private static Map<Byte, UserIsmarriedeEnum> valueMap;

    UserIsmarriedeEnum(Byte status, String displayName) {
        this.status = status;
        this.displayName = displayName;
    }

    static {
        valueMap = new HashMap();
        for (UserIsmarriedeEnum e : values())
            valueMap.put(e.status, e);
    }

    public Byte getValue() {
        return this.status;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public static UserIsmarriedeEnum getEnum(Byte key) {
        if (!valueMap.containsKey(key)) {
            return null;
        }
        return valueMap.get(key);
    }

    public Map<Byte, UserIsmarriedeEnum> getAllValueMap() {
        return valueMap;
    }


    public String getEnumName() {
        return this.name();
    }
}
