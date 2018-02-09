package com.aishang.asjf.client.mallserver.response;

import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * class_name：StoreGPSInfoDTO
 * describe: TODO
 * user: zhoujian
 * date：17-11-9
 */
public class StoreGPSInfoDTO implements Serializable {

    private double lng;     // 经度(y)

    private double lat;     // 纬度(x)

    private int scope;      // 范围

    public StoreGPSInfoDTO() {
        this.lng = 116.36;
        this.lat = 39.24;
        this.scope = 100;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public int getScope() {
        return scope;
    }

    public void setScope(int scope) {
        this.scope = scope;
    }

    @Override
    public String toString() {
        return "StoreGPSInfoDTO{" +
                "lng=" + lng +
                ", lat=" + lat +
                ", scope=" + scope +
                '}';
    }
}
