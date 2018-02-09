package com.aishang.asjf.client.crmserver.response.info;

public class EnumImage {

    private  Byte  value;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EnumImage enumImage = (EnumImage) o;

        if (value != enumImage.value) return false;
        if (name != null ? !name.equals(enumImage.name) : enumImage.name != null) return false;
        return displayName != null ? displayName.equals(enumImage.displayName) : enumImage.displayName == null;
    }

    @Override
    public int hashCode() {
        int result = (int) value;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (displayName != null ? displayName.hashCode() : 0);
        return result;
    }
}
