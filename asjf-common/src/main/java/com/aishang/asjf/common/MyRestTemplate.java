package com.aishang.asjf.common;

import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

public class MyRestTemplate {

    private static RestTemplate restTemplate;

    static {
        HttpComponentsClientHttpRequestFactory clientHttpRequestFactory
                = new HttpComponentsClientHttpRequestFactory();
        clientHttpRequestFactory.setConnectTimeout(5 * 1000);
        clientHttpRequestFactory.setReadTimeout(5 * 1000);
        restTemplate = new RestTemplate(clientHttpRequestFactory);
    }

    public static RestTemplate getInstace() {
        return restTemplate;
    }
}
