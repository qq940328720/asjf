package com.aishang.asjf.client.orderserver.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * 是否类型枚举
 * date: 2017-12-16
 *
 * @author whb
 * @version 1.0
 * @since JDK 1.8
 */
public enum WhetherEnum {

    YES(1, "是"),
    NO(0, "否");

    private final Integer status;
    private final String displayName;
    private static Map<Integer, WhetherEnum> valueMap;

    WhetherEnum(Integer status, String displayName) {
        this.status = status;
        this.displayName = displayName;
    }

    static {
        valueMap = new HashMap();
        for (WhetherEnum e : values())
            valueMap.put(e.status, e);
    }

    public Integer getValue() {
        return this.status;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public static WhetherEnum getEnum(Integer key) {
        if (!valueMap.containsKey(key)) {
            return null;
        }
        return valueMap.get(key);
    }

    public Map<Integer, WhetherEnum> getAllValueMap() {
        return valueMap;
    }

    public String getEnumName() {
        return this.name();
    }

}
