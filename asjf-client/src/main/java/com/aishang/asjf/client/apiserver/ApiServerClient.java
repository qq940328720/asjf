package com.aishang.asjf.client.apiserver;

import com.aishang.asjf.client.apiserver.response.ResponseWrapper;
import com.aishang.asjf.client.apiserver.response.SmsResponse;
import com.aishang.asjf.client.utils.MyRestTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * 第三方API系统接口客户端
 */
@Component
public class ApiServerClient {

    @Value("${api.server.sms}")
    private String api4sms;

    private RestTemplate restTemplate = MyRestTemplate.getInstace();

    public boolean sendSms(String phone, String content) throws Exception {

        Map<String, String> data = new HashMap<>(2);
        data.put("phone", phone);
        data.put("content", content);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
        HttpEntity<Map> requestEntity = new HttpEntity<>(data, httpHeaders);
        ResponseWrapper<SmsResponse> result = restTemplate.postForObject(api4sms, requestEntity, ResponseWrapper.class);
        if ("1".equals(result.getCode())) {
            return true;
        }
        return false;
    }
}
