package com.aishang.asjf.client.crmserver.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * 电话类型枚举
 *
 * @Author:whb
 * @Date：2017-10-23 17:29:40
 * @Version:1.0
 */
public enum PhoneEnum {
    TEL((byte) 1, "固话"),
    MOBILE((byte) 2, "手机");
    private final Byte status;
    private final String displayName;
    private static Map<Byte, PhoneEnum> valueMap;

    PhoneEnum(Byte status, String displayName) {
        this.status = status;
        this.displayName = displayName;
    }

    static {
        valueMap = new HashMap();
        for (PhoneEnum e : values())
            valueMap.put(e.status, e);
    }

    public Byte getValue() {
        return this.status;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public static PhoneEnum getEnum(Byte key) {
        if (!valueMap.containsKey(key)) {
            return null;
        }
        return valueMap.get(key);
    }

    public Map<Byte, PhoneEnum> getAllValueMap() {
        return valueMap;
    }

    public String getEnumName() {
        return this.name();
    }

}
