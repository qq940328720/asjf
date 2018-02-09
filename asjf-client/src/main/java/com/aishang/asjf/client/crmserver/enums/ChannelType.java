package com.aishang.asjf.client.crmserver.enums;

import java.util.HashMap;
import java.util.Map;

public enum ChannelType {

    AS(2, "爱尚"),
    XYD(1, "小雨点");

    private final Integer status;
    private final String displayName;
    private static Map<Integer, ChannelType> valueMap;

    ChannelType(Integer status, String displayName) {
        this.status = status;
        this.displayName = displayName;
    }

    static {
        valueMap = new HashMap();
        for (ChannelType e : values())
            valueMap.put(e.status, e);
    }

    public Integer getValue() {
        return this.status;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public static ChannelType getEnum(Integer key) {
        if (!valueMap.containsKey(key)) {
            return null;
        }
        return valueMap.get(key);
    }

    public Map<Integer, ChannelType> getAllValueMap() {
        return valueMap;
    }

    public String getEnumName() {
        return this.name();
    }

}
