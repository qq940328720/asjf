package com.aishang.asjf.client.crmserver.enums;

import java.util.HashMap;
import java.util.Map;

public enum RelationshipEnum {
    PARENTS((byte) 1, "父母"),
    SPOUSE((byte) 2, "配偶"),
    BROTHER_SISTER((byte) 3, "兄弟姐妹"),
    FRIENDS((byte) 4, "朋友"),
    RELATIVE((byte) 5, "亲戚"),
    COLLEGUE((byte) 6, "同事"),
    OTHER((byte) 7, "其他");

    private Byte status;
    private String displayName;
    private static Map<Byte, RelationshipEnum> valueMap;

    RelationshipEnum() {
    }

    RelationshipEnum(Byte status, String displayName) {
        this.status = status;
        this.displayName = displayName;
    }

    static {
        valueMap = new HashMap();
        for (RelationshipEnum e : values())
            valueMap.put(e.status, e);
    }

    public Byte getValue() {
        return this.status;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public static RelationshipEnum getEnum(Byte key) {
        if (!valueMap.containsKey(key)) {
            return null;
        }
        return valueMap.get(key);
    }

    public Map<Byte, RelationshipEnum> getAllValueMap() {
        return valueMap;
    }

    public String getEnumName() {
        return this.name();
    }

}
