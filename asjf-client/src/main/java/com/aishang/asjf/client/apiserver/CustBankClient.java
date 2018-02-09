package com.aishang.asjf.client.apiserver;

import com.aishang.asjf.client.apiserver.response.BankResponse;
import com.aishang.asjf.client.apiserver.response.info.BankInfo;
import com.aishang.asjf.client.apiserver.response.info.BankListResponse;
import com.aishang.asjf.client.base.ClientResponseWrapper;
import com.aishang.asjf.client.mallserver.QrServerClient;
import com.aishang.asjf.client.utils.MyRestTemplate;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by mx on 17-12-9.
 */
@Component
public class CustBankClient {

    @Value("${server.dictionary.manager.root}")
    private String dictRootUrl;//字典服务地址

    @Value("${server.bank.url}")
    private String dictBankRootUrl;//字典服务地址


    RestTemplate restTemplate = MyRestTemplate.getInstace();

    private static final Logger LOGGER = LoggerFactory.getLogger(QrServerClient.class);


    /**
     * 银行卡列表
     * @return
     */
    public ClientResponseWrapper getBankList() throws Exception{
        LOGGER.info("银行卡列表开始");
        ClientResponseWrapper wrapper = new ClientResponseWrapper();
        String bankUrl = dictRootUrl+dictBankRootUrl;
        BankResponse response = restTemplate.getForObject(bankUrl,BankResponse.class);
        if(null == response.getData()){
            wrapper.setSuccess(false);
            return wrapper;
        }
        String list = "";
        for (int i = 0; i < response.getData().size(); i++) {
            if (null != response.getData().get(i)) {
                BankListResponse listInfo = new BankListResponse();
                String dataName = response.getData().get(i).getDataName();
                list += dataName + ",";
            }
        }
        String[] str =list.split(",");
        wrapper.setData(str);
        wrapper.setSuccess(true);
        LOGGER.info("银行卡列表结束:{}",list);
        return wrapper;
    }


}
