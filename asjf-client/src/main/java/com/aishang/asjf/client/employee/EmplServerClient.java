package com.aishang.asjf.client.employee;

import com.aishang.asjf.client.base.CilentBaseResponse;
import com.aishang.asjf.client.base.ClientResponseWrapper;
import com.aishang.asjf.client.employee.response.EmplClientResponse;
import com.aishang.asjf.client.employee.response.EmplResponse;
import com.aishang.asjf.client.employee.response.EmplResponseWrapper;
import com.aishang.asjf.client.mallserver.QrServerClient;
import com.aishang.asjf.client.utils.MyRestTemplate;
import com.fasterxml.jackson.databind.JsonNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 组织机构系统，员工接口客户端
 */
@Component
public class EmplServerClient {

    @Value("${rule.manager.account.auth}")
    private String api4accountAuth;

    @Value("${server.org.manager.root}")
    private String orgManagerUrl;//组织机构根路径

    @Value("${server.org.empl.info.url}")
    private String orgEmplUrl;//组织机构--获取员工详情

    @Value("${server.rule.manager.root}")
    private String ruleRootUrl;//权限系统服务地址

    @Value("${server.rule.modityPassWord.url}")
    private String ruleModityUrl;//权限系统修改密码

    private RestTemplate restTemplate = new RestTemplate();

    private static final Logger LOGGER = LoggerFactory.getLogger(QrServerClient.class);


    public boolean check(String username, String password) {
        try {
            Map<String, String> data = new HashMap<>(2);
            data.put("account", username);
            data.put("password", password);

            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON_UTF8));
            HttpEntity requestEntity = new HttpEntity(httpHeaders);
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<JsonNode> result = restTemplate.exchange(api4accountAuth, HttpMethod.GET, requestEntity, JsonNode.class, data);
            JsonNode jsonNode = result.getBody();
            if (null != jsonNode && jsonNode.get("success").asBoolean() && jsonNode.get("executed").asBoolean()) {
                return true;
            }
        } catch (RestClientException e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }


    /**
     * 根据员工工号获取员工详情
     *
     * @param emplCode
     */
    public EmplClientResponse getEmplInfo(String emplCode) {
        LOGGER.info("获取员工详情开始:{}", emplCode);
        EmplClientResponse wrapper = new EmplClientResponse();
        EmplResponseWrapper emplResponseWrapper = new EmplResponseWrapper();
        String url = orgManagerUrl + orgEmplUrl;
        LOGGER.debug("url:{}", url);
        EmplResponse string = MyRestTemplate.getInstace().getForObject(url, EmplResponse.class, Collections.singletonMap("emplCode", emplCode));
        LOGGER.debug("结果:{}", string);
        if (string.isSuccess() && string.isExecuted()) {
            emplResponseWrapper.setEmployeeCode(string.getRows().get(0).getEmployeeCode());
            emplResponseWrapper.setname(string.getRows().get(0).getName());
            emplResponseWrapper.setMobileno(string.getRows().get(0).getMobileno());
            wrapper.setSuccess(true);
            wrapper.setData(emplResponseWrapper);
        } else {
            wrapper.setSuccess(false);
            return wrapper;
        }
        LOGGER.info("获取员工详情结束:{}", wrapper);
        return wrapper;

    }

    /**
     * 业务员修改密码
     * @param loginName
     * @param passWord
     * @return
     */
    public CilentBaseResponse EmplModifyPassword(String loginName, String passWord){
        LOGGER.info("业务员修改密码请求参数:{}",loginName+","+passWord);
        CilentBaseResponse response = new CilentBaseResponse();
        String modityPassWordUrl = ruleRootUrl+ruleModityUrl+"/"+loginName+"/"+passWord;
        ResponseEntity<CilentBaseResponse> respons = restTemplate.exchange(modityPassWordUrl, HttpMethod.PUT, null, CilentBaseResponse.class);
        if(!respons.getBody().isSuccess() && !respons.getBody().isExecuted()){
            response.setSuccess(false);
            return response;
        }
        LOGGER.info("业务员修改密码结束:{}",respons.getBody().getMessage());
        return response;
    }


}
