package com.aishang.asjf.client.crmserver.response;

import java.io.Serializable;
import java.sql.Timestamp;

public class AreaInfoResponse  implements Serializable {

    /**
     * @Fields serialVersionUID : TODO
     */
    private static final long serialVersionUID = 1L;

    private String code;
    private String name;
    private String level;                            // '1、省（包括直辖市、自治区）2、市3、区4、街道'
    private String nameEn;
    private String nameAbbr;
    private String cityCode;
    private String provinceCode;
    private Object isAvailable;                        // 0: 旧版 1: 新版
    private int version;
    private Timestamp createTime;                // 创建时间
    private Timestamp updateTime;                // 最后更新时间



    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    public String getNameAbbr() {
        return nameAbbr;
    }

    public void setNameAbbr(String nameAbbr) {
        this.nameAbbr = nameAbbr;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    public Object getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(Object isAvailable) {
        this.isAvailable = isAvailable;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }
}
