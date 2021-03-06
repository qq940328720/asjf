package com.aishang.asjf.client.orderserver.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * 支持期数单位
 */
public enum PaytimeUnitEnum{

    YEAR(1, "年"),
    MONTH(2, "月"),
    DAY(3, "日"),
    SEASON(4, "季");

    private final Integer status;
    private final String displayName;
    private static Map<Integer, PaytimeUnitEnum> valueMap;

    PaytimeUnitEnum(Integer status, String displayName) {
        this.status = Integer.valueOf(status);
        this.displayName = displayName;
    }

    static {
        valueMap = new HashMap();
        for (PaytimeUnitEnum e : values())
            valueMap.put(e.status, e);
    }

    public Integer getValue() {
        return this.status;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public static PaytimeUnitEnum getEnum(Integer key) {
        if (!valueMap.containsKey(key)) {
            return null;
        }
        return valueMap.get(key);
    }

    public Map<Integer, PaytimeUnitEnum> getAllValueMap() {
        return valueMap;
    }

    public String getEnumName() {
        return this.name();
    }
}