package com.aishang.asjf.client.crmserver.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * 是否签约成功
 * date: 2017-12-16
 *
 * @author whb
 * @version 1.0
 * @since JDK 1.8
 */
public enum SignatureEnum {

    SIGSUCCESS(1, "签约成功"),
    NOSIGNA(0, "未签约");

    private final Integer status;
    private final String displayName;
    private static Map<Integer, SignatureEnum> valueMap;

    SignatureEnum(Integer status, String displayName) {
        this.status = status;
        this.displayName = displayName;
    }

    static {
        valueMap = new HashMap();
        for (SignatureEnum e : values())
            valueMap.put(e.status, e);
    }

    public Integer getValue() {
        return this.status;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public static SignatureEnum getEnum(Integer key) {
        if (!valueMap.containsKey(key)) {
            return null;
        }
        return valueMap.get(key);
    }

    public Map<Integer, SignatureEnum> getAllValueMap() {
        return valueMap;
    }

    public String getEnumName() {
        return this.name();
    }

}
