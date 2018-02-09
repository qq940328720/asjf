package com.aishang.asjf.client.crmserver.enums;

import java.util.HashMap;
import java.util.Map;

public class EnumObject {

    private  Object value;

    private  String name;

    private  String displayName;

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
}
