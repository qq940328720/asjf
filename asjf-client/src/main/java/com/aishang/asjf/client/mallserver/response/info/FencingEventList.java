package com.aishang.asjf.client.mallserver.response.info;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

/**
 * Created by mx on 17-12-5.
 */
@JsonDeserialize(using = FencingEventList.FencingEventListDeserializer.class)
public class FencingEventList implements Serializable {

    private String clientAction;//client_action;
    private String clientStatus;//client_status;
    private String enterTime;//enter_time;
    private FenceInfo fenceInfo;//enter_time;
//    private List<FenceInfo> fenceInfo;//fence_info;
//    private Object fenceInfo;//fence_info;


    public String getClientAction() {
        return clientAction;
    }

    public void setClientAction(String clientAction) {
        this.clientAction = clientAction;
    }

    public String getClientStatus() {
        return clientStatus;
    }

    public void setClientStatus(String clientStatus) {
        this.clientStatus = clientStatus;
    }

    public String getEnterTime() {
        return enterTime;
    }

    public void setEnterTime(String enterTime) {
        this.enterTime = enterTime;
    }

    public FenceInfo getFenceInfo() {
        return fenceInfo;
    }

    public void setFenceInfo(FenceInfo fenceInfo) {
        this.fenceInfo = fenceInfo;
    }

    public static class FencingEventListDeserializer extends JsonDeserializer<FencingEventList> {

        private static ObjectMapper objectMapper=new ObjectMapper();

        @Override
        public FencingEventList deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {

            if (null != jsonParser) {
                ObjectCodec objectCodec = jsonParser.getCodec();
                JsonNode jsonNode = objectCodec.readTree(jsonParser);
                FencingEventList account = new FencingEventList();
                account.setClientAction(jsonNode.path("client_action").asText());
                account.setClientStatus(jsonNode.path("client_status").asText());
                account.setEnterTime(jsonNode.path("enter_time").asText());
                account.setFenceInfo(new ObjectMapper().convertValue(jsonNode.path("fence_info"), FenceInfo.class));
//                List<FenceInfo> fencingEventList = objectMapper.convertValue(jsonNode.path("FenceInfo"), new TypeReference<List<FenceInfo>>() { });

                return account;
            }
            return null;
        }
    }
}
