package com.aishang.asjf.client.crmserver.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * 资金来源
 * Created by WHB on 17-12-22.
 */
public enum MoneyResourceEnum {

    XYD(1, "小雨点"),
    AS(3, "爱尚");

    private final Integer status;
    private final String displayName;
    private static Map<Integer, MoneyResourceEnum> valueMap;

    MoneyResourceEnum(Integer status, String displayName) {
        this.status = Integer.valueOf(status);
        this.displayName = displayName;
    }

    static {
        valueMap = new HashMap();
        for (MoneyResourceEnum e : values())
            valueMap.put(e.status, e);
    }

    public Integer getValue() {
        return this.status;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public MoneyResourceEnum getEnum(Integer key) {
        if (!valueMap.containsKey(key)) {
            return null;
        }
        return valueMap.get(key);
    }

    public Map<Integer, MoneyResourceEnum> getAllValueMap() {
        return valueMap;
    }

    public String getEnumName() {
        return this.name();
    }
}
