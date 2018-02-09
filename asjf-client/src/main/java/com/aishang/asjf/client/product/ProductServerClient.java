package com.aishang.asjf.client.product;

import com.aishang.asjf.client.crmserver.CrmServerClient;
import com.aishang.asjf.client.crmserver.response.IsSupportAsResponse;
import com.aishang.asjf.client.orderserver.OrderServerClient;
import com.aishang.asjf.client.product.response.ProductInfoResponse;
import com.aishang.asjf.client.utils.MyObjectMapper;
import com.aishang.asjf.client.utils.MyRestTemplate;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * 产品系统接口客户端
 */
@Component
public class ProductServerClient {


    @Value("${server.product.manager.root}")
    private String productUrl;//资金渠道服务地址


    private RestTemplate restTemplate = MyRestTemplate.getInstace();


    private static final Logger LOGGER = LoggerFactory.getLogger(CrmServerClient.class);

    /**
     * 获取产品详情
     *
     * @return
     * @throws Exception
     */
    public JsonNode getProductInfo(String productCode) throws Exception {
        LOGGER.info("获取产品详情,入参{}" + productCode);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
        String orderUrl = productUrl + "/outProduct/" + productCode + "/getProductInfoByProductCode";
        JsonNode resultData = null;
        JsonNode jsonNode = restTemplate.getForObject(orderUrl, JsonNode.class);
        if (jsonNode.get("executed").asBoolean()) {
            return jsonNode;
        }
        LOGGER.info("获取产品详情方法结束，resultData:{" + resultData + "}");
        return null;
    }
}
