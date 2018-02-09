package com.aishang.asjf.client.crmserver.request;


public class AreaRequest {

    private String code;
    private String name;
    private String level;                            // '1、省（包括直辖市、自治区）2、市3、区4、街道'
    private String nameEn;
    private String nameAbbr;
    private String cityCode;
    private String provinceCode;
    private String isAvailable;
    private String version;

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getLevel() {
        return level;
    }

    public String getNameEn() {
        return nameEn;
    }

    public String getNameAbbr() {
        return nameAbbr;
    }

    public String getCityCode() {
        return cityCode;
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public String getVersion() {
        return version;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    public void setNameAbbr(String nameAbbr) {
        this.nameAbbr = nameAbbr;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(String isAvailable) {
        this.isAvailable = isAvailable;
    }


}
