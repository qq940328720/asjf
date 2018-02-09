package com.aishang.asjf.client.crmserver.request;

import java.util.List;

public class UserTeleListRequest {

    private List<TelepRequest> userTelList;

    public List<TelepRequest> getUserTelList() {
        return userTelList;
    }

    public void setUserTelList(List<TelepRequest> userTelList) {
        this.userTelList = userTelList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserTeleListRequest that = (UserTeleListRequest) o;

        return userTelList != null ? userTelList.equals(that.userTelList) : that.userTelList == null;
    }

    @Override
    public int hashCode() {
        return userTelList != null ? userTelList.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "UserTeleListRequest{" +
                "userTelList=" + userTelList +
                '}';
    }
}
