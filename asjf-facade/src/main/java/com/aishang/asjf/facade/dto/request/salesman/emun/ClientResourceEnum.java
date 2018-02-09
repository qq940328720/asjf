package com.aishang.asjf.facade.dto.request.salesman.emun;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mx on 17-12-4.
 */
public enum ClientResourceEnum implements BaseEnum<ClientResourceEnum, Byte>  {
    ANDROID((byte) 1, "安卓"),
    IOS((byte) 2, "IOS");

    private final Byte status;
    private final String displayName;
    private static Map<Byte, ClientResourceEnum> valueMap;

    ClientResourceEnum(Byte status, String displayName) {
        this.status = status;
        this.displayName = displayName;
    }

    static {
        valueMap = new HashMap();
        for (ClientResourceEnum e : values())
            valueMap.put(e.status, e);
    }

    public Byte getValue() {
        return this.status;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public static ClientResourceEnum getEnum(Byte key) {
        if (!valueMap.containsKey(key)) {
            return null;
        }
        return valueMap.get(key);
    }

    public Map<Byte, ClientResourceEnum> getAllValueMap() {
        return valueMap;
    }

    @Override
    public String getEnumName() {
        return this.name();
    }
}
