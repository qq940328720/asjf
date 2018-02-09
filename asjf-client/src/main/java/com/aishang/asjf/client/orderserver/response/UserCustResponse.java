package com.aishang.asjf.client.orderserver.response;

import com.aishang.asjf.client.base.CilentBaseResponse;

public class UserCustResponse extends CilentBaseResponse {

   private UserAccPwdResponse data;

   @Override
   public String toString() {
      return "UserCustResponse{" +
              "data=" + data +
              '}';
   }

   public UserAccPwdResponse getData() {
      return data;
   }

   public void setData(UserAccPwdResponse data) {
      this.data = data;
   }
}
