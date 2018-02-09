package com.aishang.asjf.client.crmserver.enums;


import java.util.HashMap;
import java.util.Map;

public enum ImageTypeEnum {
    IDENTITY_HEAD((byte) 1, "身份证正面照"),
    IDENTITY_EMBLEM((byte) 2, "身份证反面照"),
    HOLD_IDENTITY((byte) 3, "手持身份证照片"),
    CONFIM((byte) 4, "手持确认书照片"),
    CREDIT_OHTERS((byte) 5, "信审其他照片");
    private final Byte status;
    private final String displayName;
    private static Map<Byte, ImageTypeEnum> valueMap;

    ImageTypeEnum(Byte status, String displayName) {
        this.status = status;
        this.displayName = displayName;
    }

    static {
        valueMap = new HashMap();
        for (ImageTypeEnum e : values())
            valueMap.put(e.status, e);
    }

    public Byte getValue() {
        return this.status;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public static ImageTypeEnum getEnum(Byte key) {
        if (!valueMap.containsKey(key)) {
            return null;
        }
        return valueMap.get(key);
    }

    public Map<Byte, ImageTypeEnum> getAllValueMap() {
        return valueMap;
    }

    public String getEnumName() {
        return this.name();
    }
}
