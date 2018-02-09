package com.aishang.asjf.client.crmserver.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * 是否支持类型枚举
 * date: 2017-12-16
 *
 * @author whb
 * @version 1.0
 * @since JDK 1.8
 */
public enum AdmissionEnum {

    ADMISSION(1, "允许"),
    UNADMISSION(0, "不允许");

    private final Integer status;
    private final String displayName;
    private static Map<Integer, AdmissionEnum> valueMap;

    AdmissionEnum(Integer status, String displayName) {
        this.status = status;
        this.displayName = displayName;
    }

    static {
        valueMap = new HashMap();
        for (AdmissionEnum e : values())
            valueMap.put(e.status, e);
    }

    public Integer getValue() {
        return this.status;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public static AdmissionEnum getEnum(Integer key) {
        if (!valueMap.containsKey(key)) {
            return null;
        }
        return valueMap.get(key);
    }

    public Map<Integer, AdmissionEnum> getAllValueMap() {
        return valueMap;
    }

    public String getEnumName() {
        return this.name();
    }

}
