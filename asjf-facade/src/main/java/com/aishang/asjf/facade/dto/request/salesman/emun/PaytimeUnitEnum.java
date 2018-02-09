package com.aishang.asjf.facade.dto.request.salesman.emun;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author mx
 * @Data 17-11-21 下午4:30
 */
public enum PaytimeUnitEnum implements BaseEnum<PaytimeUnitEnum, Byte> {

    YEAR((byte) 1, "年"),
    MONTH((byte) 2, "月"),
    DAY((byte) 3, "日"),
    SEASON((byte) 4, "季");

    private final Byte status;
    private final String displayName;
    private static Map<Byte, PaytimeUnitEnum> valueMap;

    PaytimeUnitEnum(Byte status, String displayName) {
        this.status = status;
        this.displayName = displayName;
    }

    static {
        valueMap = new HashMap();
        for (PaytimeUnitEnum e : values())
            valueMap.put(e.status, e);
    }

    public Byte getValue() {
        return this.status;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public static PaytimeUnitEnum getEnum(Byte key) {
        if (!valueMap.containsKey(key)) {
            return null;
        }
        return valueMap.get(key);
    }

    public Map<Byte, PaytimeUnitEnum> getAllValueMap() {
        return valueMap;
    }

    @Override
    public String getEnumName() {
        return this.name();
    }
}
