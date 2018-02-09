package com.aishang.asjf.facade.dto.request.salesman.emun;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author mx
 * @Data 17-11-21 下午4:30
 */
public enum SortEnum implements BaseEnum<SortEnum, Byte> {

    /* ASC(1, "升序"),
     DESC(2, "降序");*/
    ASC((byte) 1, "升序"),
    DESC((byte) 2, "降序");

    private final Byte status;
    private final String displayName;
    private static Map<Byte, SortEnum> valueMap;

    SortEnum(Byte status, String displayName) {
        this.status = status;
        this.displayName = displayName;
    }

    static {
        valueMap = new HashMap();
        for (SortEnum e : values())
            valueMap.put(e.status, e);
    }

    public Byte getValue() {
        return this.status;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public static SortEnum getEnum(Byte key) {
        if (!valueMap.containsKey(key)) {
            return null;
        }
        return valueMap.get(key);
    }

    public Map<Byte, SortEnum> getAllValueMap() {
        return valueMap;
    }

    @Override
    public String getEnumName() {
        return this.name();
    }
}
