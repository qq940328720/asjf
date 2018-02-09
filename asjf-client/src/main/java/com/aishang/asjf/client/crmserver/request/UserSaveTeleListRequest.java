package com.aishang.asjf.client.crmserver.request;

import java.util.List;

public class UserSaveTeleListRequest {

    private List<TeleSaveRequest> userTelList;

    private String orderCode;

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public List<TeleSaveRequest> getUserTelList() {
        return userTelList;
    }

    public void setUserTelList(List<TeleSaveRequest> userTelList) {
        this.userTelList = userTelList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserSaveTeleListRequest that = (UserSaveTeleListRequest) o;

        if (userTelList != null ? !userTelList.equals(that.userTelList) : that.userTelList != null) return false;
        return orderCode != null ? orderCode.equals(that.orderCode) : that.orderCode == null;
    }

    @Override
    public int hashCode() {
        int result = userTelList != null ? userTelList.hashCode() : 0;
        result = 31 * result + (orderCode != null ? orderCode.hashCode() : 0);
        return result;
    }

}
