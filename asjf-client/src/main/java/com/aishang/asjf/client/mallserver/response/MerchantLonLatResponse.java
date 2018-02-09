package com.aishang.asjf.client.mallserver.response;

import com.aishang.asjf.client.base.CilentBaseResponse;

/**
 * Created by mx on 17-12-4.
 */
public class MerchantLonLatResponse extends CilentBaseResponse {

    private String lon;//经度
    private String lat;//纬度

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MerchantLonLatResponse that = (MerchantLonLatResponse) o;

        if (lon != null ? !lon.equals(that.lon) : that.lon != null) return false;
        return lat != null ? lat.equals(that.lat) : that.lat == null;
    }

    @Override
    public int hashCode() {
        int result = lon != null ? lon.hashCode() : 0;
        result = 31 * result + (lat != null ? lat.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "MerchantLonLatResponse{" +
                "lon='" + lon + '\'' +
                ", lat='" + lat + '\'' +
                '}';
    }
}
