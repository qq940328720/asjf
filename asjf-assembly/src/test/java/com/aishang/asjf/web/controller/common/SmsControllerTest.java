package com.aishang.asjf.web.controller.common;

import com.aishang.asjf.client.utils.MyObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

class SmsControllerTest {

    JedisConnectionFactory jedisConnectionFactory = null;
    StringRedisTemplate stringRedisTemplate = null;
    String hostName = "127.0.0.1";
    int port = 6379;

    @Before
    void before() {
////        jedisConnectionFactory = new JedisConnectionFactory(new RedisStandaloneConfiguration(hostName, port));
//        jedisConnectionFactory.afterPropertiesSet();
//
//        stringRedisTemplate.setConnectionFactory(jedisConnectionFactory);
//        stringRedisTemplate.afterPropertiesSet();
    }

    @Test
    void send() throws Exception {
        List<Map> data = new ArrayList<>();
//        for (int i = 0 ; i < 10; i++){
        data.add(Collections.singletonMap("a", "ME|D:99000936540684"));
        data.add(Collections.singletonMap("a", "ME|1:99000936540684"));
        data.add(Collections.singletonMap("a", "ME|2:99000936540684"));
//        }
        String str = MyObjectMapper.getInstance().writeValueAsString(data);
        System.out.println(str);
        System.out.println("###########################");
        JsonNode jsonString = MyObjectMapper.getInstance().readTree(str);

        for (int i = 0; i < jsonString.size(); i++) {
            String a = jsonString.get(i).get("a").asText();
            if (a.startsWith("ME|1:")) {
                System.out.println(a);
                break;
            }
        }

    }

}