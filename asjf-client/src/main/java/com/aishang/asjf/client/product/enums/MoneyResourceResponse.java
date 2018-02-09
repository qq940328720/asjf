package com.aishang.asjf.client.product.enums;

import java.io.Serializable;

public class MoneyResourceResponse implements Serializable {

    private  Byte value;

    private  String name;

    private  String displayName;

    public Byte getValue() {
        return value;
    }

    public void setValue(Byte value) {
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
