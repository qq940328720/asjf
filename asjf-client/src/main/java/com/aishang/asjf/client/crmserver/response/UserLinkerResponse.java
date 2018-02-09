package com.aishang.asjf.client.crmserver.response;


import com.aishang.asjf.client.base.CilentBaseResponse;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by whb on 17-11-14.
 */
@XmlRootElement(name = "userLinkerResponse")
public class UserLinkerResponse extends CilentBaseResponse {


    private List<UserLinkerInfoResponse> resultDatas;

    @Override
    public String toString() {
        return "UserLinkerResponse{" +
                "resultDatas=" + resultDatas +
                '}';
    }

    public List<UserLinkerInfoResponse> getResultDatas() {
        return resultDatas;
    }

    public void setResultDatas(List<UserLinkerInfoResponse> resultDatas) {
        this.resultDatas = resultDatas;
    }
}
