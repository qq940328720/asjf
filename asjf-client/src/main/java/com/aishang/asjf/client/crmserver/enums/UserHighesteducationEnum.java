package com.aishang.asjf.client.crmserver.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author 李通
 * @Data 17-11-20 上午11:12
 */
public enum UserHighesteducationEnum {
    PRIMARY_SCHOOL((byte) 1, "小学及以下"),
    MIDDLE_SCHOOL((byte) 2, "中学"),
    COLLEGE((byte) 3, "大学专科"),
    UNDERGRADUATE((byte) 4, "大学本科"),
    POSTGRADUATE((byte) 5, "研究生及以上");

    private final Byte status;
    private final String displayName;
    private static Map<Byte, UserHighesteducationEnum> valueMap;

    UserHighesteducationEnum(Byte status, String displayName) {
        this.status = status;
        this.displayName = displayName;
    }

    static {
        valueMap = new HashMap();
        for (UserHighesteducationEnum e : values())
            valueMap.put(e.status, e);
    }

    public Byte getValue() {
        return this.status;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public static UserHighesteducationEnum getEnum(Byte key) {
        if (!valueMap.containsKey(key)) {
            return null;
        }
        return valueMap.get(key);
    }

    public Map<Byte, UserHighesteducationEnum> getAllValueMap() {
        return valueMap;
    }

    public String getEnumName() {
        return this.name();
    }
}
