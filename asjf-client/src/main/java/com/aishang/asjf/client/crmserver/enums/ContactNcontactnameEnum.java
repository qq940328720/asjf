package com.aishang.asjf.client.crmserver.enums;

import java.util.HashMap;
import java.util.Map;

public enum ContactNcontactnameEnum {
    //第几联系人
    //第几联系人
    CONTACT_1ST((byte) 1, "第一联系人"),
    CONTACT_2ND((byte) 2, "第二联系人"),
    CONTACT_3RD((byte) 3, "第三联系人");


    private final Byte status;
    private final String displayName;
    private static Map<Byte, ContactNcontactnameEnum> valueMap;

    ContactNcontactnameEnum(Byte status, String displayName) {
        this.status = status;
        this.displayName = displayName;
    }

    static {
        valueMap = new HashMap();
        for (ContactNcontactnameEnum e : values())
            valueMap.put(e.status, e);
    }

    public Byte getValue() {
        return this.status;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public static ContactNcontactnameEnum getEnum(Byte key) {
        if (!valueMap.containsKey(key)) {
            return null;
        }
        return valueMap.get(key);
    }

    public Map<Byte, ContactNcontactnameEnum> getAllValueMap() {
        return valueMap;
    }

    public String getEnumName() {
        return this.name();
    }

}
