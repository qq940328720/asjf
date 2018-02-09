package com.aishang.asjf.client.crmserver.response;

import com.aishang.asjf.client.base.CilentBaseResponse;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
@JsonInclude(JsonInclude.Include.NON_EMPTY )
public class UserProfileResponse implements Serializable {

    private List<UserProfileCompleteResponse.Data> userProfileComplete;

//    private BigDecimal oddMoney =new BigDecimal("235");
    private String orderNum;

    private String code;

    public List<UserProfileCompleteResponse.Data> getUserProfileComplete() {
        return userProfileComplete;
    }

    public void setUserProfileComplete(List<UserProfileCompleteResponse.Data> userProfileComplete) {
        this.userProfileComplete = userProfileComplete;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        if(null == orderNum){
            orderNum = "";
        }
        this.orderNum = orderNum;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserProfileResponse that = (UserProfileResponse) o;

        if (userProfileComplete != null ? !userProfileComplete.equals(that.userProfileComplete) : that.userProfileComplete != null)
            return false;
        if (orderNum != null ? !orderNum.equals(that.orderNum) : that.orderNum != null) return false;
        return code != null ? code.equals(that.code) : that.code == null;
    }

    @Override
    public int hashCode() {
        int result = userProfileComplete != null ? userProfileComplete.hashCode() : 0;
        result = 31 * result + (orderNum != null ? orderNum.hashCode() : 0);
        result = 31 * result + (code != null ? code.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "UserProfileResponse{" +
                "userProfileComplete=" + userProfileComplete +
                ", orderNum='" + orderNum + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
