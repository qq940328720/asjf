package com.aishang.asjf.client.crmserver.enums;

import java.util.HashMap;
import java.util.Map;

public enum IsFormalEnum {

    YES(1,"是"),
    NO(2,"否");

    private final Integer status;
    private final String displayName;
    private static Map<Integer, IsFormalEnum> valueMap;

    IsFormalEnum(Integer status, String displayName) {
        this.status = status;
        this.displayName = displayName;
    }

    static {
        valueMap = new HashMap();
        for (IsFormalEnum e : values())
            valueMap.put(e.status, e);
    }

    public Integer getValue() {
        return this.status;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public static IsFormalEnum getEnum(Integer key) {
        if (!valueMap.containsKey(key)) {
            return null;
        }
        return valueMap.get(key);
    }

    public Map<Integer, IsFormalEnum> getAllValueMap() {
        return valueMap;
    }

    public String getEnumName() {
        return this.name();
    }

}
