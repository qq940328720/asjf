package com.aishang.asjf.client.crmserver.response;

import java.io.Serializable;

public class EnumIntValue implements Serializable {

    private  int value;

    private  String name;

    private  String displayName;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
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
