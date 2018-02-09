package com.aishang.asjf.client.crmserver.response;


import com.aishang.asjf.client.base.CilentBaseResponse;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by whb on 17-11-14.
 */
@XmlRootElement(name = "userLinkerResponse")
public class LinkerListOutResponse extends CilentBaseResponse {


    private List<UserLinkerOutResponse> resultDatas;

    @Override
    public String toString() {
        return "LinkerListOutResponse{" +
                "resultDatas=" + resultDatas +
                '}';
    }

    public List<UserLinkerOutResponse> getResultDatas() {
        return resultDatas;
    }

    public void setResultDatas(List<UserLinkerOutResponse> resultDatas) {
        this.resultDatas = resultDatas;
    }
}
