package com.aishang.asjf.client.mallserver;

import com.aishang.asjf.client.base.ClientResponseWrapper;
import com.aishang.asjf.client.mallserver.response.StoretResponse;
import com.aishang.asjf.client.utils.MyRestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Collections;

/**
 * Created by mx on 17-11-22.
 */
@Component
public class StoreClient {

    @Value("${server.store.binding.manager.root}")
    private String storeRootUrl;//门店服务地址

    @Value("${sever.storte.url}")
    private String storteUrl;//选择业务员绑定的门店

    private static final Logger LOGGER = LoggerFactory.getLogger(QrServerClient.class);

    /**
     * 选择该业务员绑定的门店
     *
     * @param mepCode
     * @return
     * @throws IOException
     */
    public ClientResponseWrapper getStores(String mepCode) throws IOException {
        LOGGER.info("选择门店开始:{}", mepCode);
        ClientResponseWrapper clientResponseWrapper = new ClientResponseWrapper();
        if (null == mepCode) {
            return null;
        }
        String url = storeRootUrl + storteUrl;
        LOGGER.debug("url:{}", url);
        StoretResponse string = MyRestTemplate.getInstace().getForObject(url, StoretResponse.class, Collections.singletonMap("mepCode", mepCode));
        if (string.isSuccess() && string.isExecuted()) {
            clientResponseWrapper.setSuccess(true);
            clientResponseWrapper.setData(string.getStoresInfoDTO());
        } else {
            clientResponseWrapper.setSuccess(false);
            return clientResponseWrapper;
        }
        LOGGER.info("选择门店结束:{}", string);
        return clientResponseWrapper;
    }

}
