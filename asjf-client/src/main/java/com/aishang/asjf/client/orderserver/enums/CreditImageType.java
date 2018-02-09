package com.aishang.asjf.client.orderserver.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * 信审照片类型枚举
 * date: 2017-12-05
 *
 * @author whb
 * @version 1.0
 * @since JDK 1.8
 */
public enum CreditImageType  {

    IDENTITY_HEAD(1, "身份证正面照"),
    IDENTITY_EMBLEM(2, "身份证反面照"),
    HOLD_IDENTITY(3, "手持身份证照片"),
    CONFIM(4, "征信照片"),
    OTHERS(5, "其他照片");

    private final Integer status;
    private final String displayName;
    private static Map<Integer, CreditImageType> valueMap;

    CreditImageType(Integer status, String displayName) {
        this.status = status;
        this.displayName = displayName;
    }

    static {
        valueMap = new HashMap();
        for (CreditImageType e : values())
            valueMap.put(e.status, e);
    }

    public Integer getValue() {
        return this.status;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public static CreditImageType getEnum(Integer key) {
        if (!valueMap.containsKey(key)) {
            return null;
        }
        return valueMap.get(key);
    }

    public Map<Integer, CreditImageType> getAllValueMap() {
        return valueMap;
    }

    public String getEnumName() {
        return this.name();
    }

}
