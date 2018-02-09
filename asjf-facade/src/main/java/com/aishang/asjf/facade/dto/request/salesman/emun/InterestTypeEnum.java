package com.aishang.asjf.facade.dto.request.salesman.emun;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author mx
 * @Data 17-11-21 下午4:30
 */
public enum InterestTypeEnum implements BaseEnum<InterestTypeEnum, Byte> {

    AVERAGEINTEREST((byte) 1, "等额本息"),
    AVERAGECAPITAL((byte) 2, "等额本金"),
    AVERAGECAPITALINTEREST((byte) 3, "等本等息");

    private final Byte status;
    private final String displayName;
    private static Map<Byte, InterestTypeEnum> valueMap;

    InterestTypeEnum(Byte status, String displayName) {
        this.status = status;
        this.displayName = displayName;
    }

    static {
        valueMap = new HashMap();
        for (InterestTypeEnum e : values())
            valueMap.put(e.status, e);
    }

    public Byte getValue() {
        return this.status;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public static InterestTypeEnum getEnum(Byte key) {
        if (!valueMap.containsKey(key)) {
            return null;
        }
        return valueMap.get(key);
    }

    public Map<Byte, InterestTypeEnum> getAllValueMap() {
        return valueMap;
    }

    @Override
    public String getEnumName() {
        return this.name();
    }
}
