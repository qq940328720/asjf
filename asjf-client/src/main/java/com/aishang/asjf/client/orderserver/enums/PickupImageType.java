package com.aishang.asjf.client.orderserver.enums;

import java.util.HashMap;
import java.util.Map;

public enum PickupImageType {

    BANKCARD(1, "银行卡照片"),
    GROUP(2, "客户+员工+工牌合照"),
    STRINGCODE(3, "串码照片"),
    STRINGCODE_SHOT(4, "串码照片特写"),
    SELF(5, "客户自提单照片"),
    SIGNPAY(6, "打款凭证照片"),
    OTHERS(7, "其他照片");

    private final Integer status;
    private final String displayName;
    private static Map<Integer, PickupImageType> valueMap;

    PickupImageType(Integer status, String displayName) {
        this.status = status;
        this.displayName = displayName;
    }

    static {
        valueMap = new HashMap();
        for (PickupImageType e : values())
            valueMap.put(e.status, e);
    }

    public Integer getValue() {
        return this.status;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public static PickupImageType getEnum(Integer key) {
        if (!valueMap.containsKey(key)) {
            return null;
        }
        return valueMap.get(key);
    }

    public Map<Integer, PickupImageType> getAllValueMap() {
        return valueMap;
    }

    public String getEnumName() {
        return this.name();
    }

}
