package com.aishang.asjf.client.crmserver.response;

import com.aishang.asjf.client.base.CilentBaseResponse;

/**
 * 客户现住址信息实体
 * Created by whb on 17-11-10.
 */
public class UserAddressResponse extends CilentBaseResponse {

    private UserAddressInfoResponse userAddressInfoDTO;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserAddressResponse that = (UserAddressResponse) o;

        return userAddressInfoDTO != null ? userAddressInfoDTO.equals(that.userAddressInfoDTO) : that.userAddressInfoDTO == null;
    }

    @Override
    public int hashCode() {
        return userAddressInfoDTO != null ? userAddressInfoDTO.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "UserAddressResponse{" +
                "userAddressInfoDTO=" + userAddressInfoDTO +
                '}';
    }

    public UserAddressInfoResponse getUserAddressInfoDTO() {
        return userAddressInfoDTO;
    }

    public void setUserAddressInfoDTO(UserAddressInfoResponse userAddressInfoDTO) {
        this.userAddressInfoDTO = userAddressInfoDTO;
    }
}
