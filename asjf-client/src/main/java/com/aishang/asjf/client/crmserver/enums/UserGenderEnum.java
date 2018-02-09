package com.aishang.asjf.client.crmserver.enums;

import java.util.HashMap;
import java.util.Map;


public enum UserGenderEnum {
    MALE((byte) 1, "男"),

    FEMALE((byte) 2, "女");
    private final Byte status;
    private final String displayName;
    private static Map<Byte, UserGenderEnum> valueMap;

    UserGenderEnum(Byte status, String displayName) {
        this.status = status;
        this.displayName = displayName;
    }

    static {
        valueMap = new HashMap();
        for (UserGenderEnum e : values())
            valueMap.put(e.status, e);
    }

    public Byte getValue() {
        return this.status;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public static UserGenderEnum getEnum(Byte key) {
        if (!valueMap.containsKey(key)) {
            return null;
        }
        return valueMap.get(key);
    }

    public Map<Byte, UserGenderEnum> getAllValueMap() {
        return valueMap;
    }

    public String getEnumName() {
        return this.name();
    }
}
