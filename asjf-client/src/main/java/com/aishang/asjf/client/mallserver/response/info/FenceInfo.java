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
@JsonDeserialize(using = FenceInfo.FenceInfoDeserializer.class)
public class FenceInfo implements Serializable {

    private String fenceCenter;//fence_center
    private String fenceGid;//fence_gid
    private String fenceName;//fence_name

    public String getFenceCenter() {
        return fenceCenter;
    }

    public void setFenceCenter(String fenceCenter) {
        this.fenceCenter = fenceCenter;
    }

    public String getFenceGid() {
        return fenceGid;
    }

    public void setFenceGid(String fenceGid) {
        this.fenceGid = fenceGid;
    }

    public String getFenceName() {
        return fenceName;
    }

    public void setFenceName(String fenceName) {
        this.fenceName = fenceName;
    }

    public static class FenceInfoDeserializer extends JsonDeserializer<FenceInfo> {

        private static ObjectMapper objectMapper=new ObjectMapper();

        @Override
        public FenceInfo deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {

            if (null != jsonParser) {
                ObjectCodec objectCodec = jsonParser.getCodec();
                JsonNode jsonNode = objectCodec.readTree(jsonParser);
                FenceInfo account = new FenceInfo();
                account.setFenceCenter(jsonNode.path("fence_center").asText());
                account.setFenceGid(jsonNode.path("fence_gid").asText());
                account.setFenceName(jsonNode.path("fence_name").asText());
                return account;
            }
            return null;
        }
    }
}
