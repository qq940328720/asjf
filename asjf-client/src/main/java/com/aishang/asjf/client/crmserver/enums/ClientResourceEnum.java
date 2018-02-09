package com.aishang.asjf.client.crmserver.enums;

import java.util.HashMap;
import java.util.Map;

public enum ClientResourceEnum {

    ANDROID( 1, "android"),
    IOS( 2, "ios");

    private final Integer status;
    private final String displayName;
    private static Map<Integer, ClientResourceEnum> valueMap;

    ClientResourceEnum(Integer status, String displayName) {
        this.status = status;
        this.displayName = displayName;
    }

    static {
        valueMap = new HashMap();
        for (ClientResourceEnum e : values())
            valueMap.put(e.status, e);
    }

    public Integer getValue() {
        return this.status;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public static ClientResourceEnum getEnum(Integer key) {
        if (!valueMap.containsKey(key)) {
            return null;
        }
        return valueMap.get(key);
    }

    public Map<Integer, ClientResourceEnum> getAllValueMap() {
        return valueMap;
    }

    public String getEnumName() {
        return this.name();
    }

}
