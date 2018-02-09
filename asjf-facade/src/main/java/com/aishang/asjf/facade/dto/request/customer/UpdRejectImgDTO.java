package com.aishang.asjf.facade.dto.request.customer;

import com.aishang.asjf.facade.dto.info.RejectImgInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * Created by whb on 17-12-21.
 */
@ApiModel(description = "修改驳回照片请求实体")
public class UpdRejectImgDTO {

    @ApiModelProperty(value = "照片列表")
    private List<RejectImgInfo> recieveData;

    @ApiModelProperty(value = "手机串码(非手机类产品不传)")
    private String stringCode;

    public List<RejectImgInfo> getRecieveData() {
        return recieveData;
    }

    public void setRecieveData(List<RejectImgInfo> recieveData) {
        this.recieveData = recieveData;
    }

    public String getStringCode() {
        return stringCode;
    }

    public void setStringCode(String stringCode) {
        this.stringCode = stringCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UpdRejectImgDTO that = (UpdRejectImgDTO) o;

        if (recieveData != null ? !recieveData.equals(that.recieveData) : that.recieveData != null) return false;
        return stringCode != null ? stringCode.equals(that.stringCode) : that.stringCode == null;
    }

    @Override
    public int hashCode() {
        int result = recieveData != null ? recieveData.hashCode() : 0;
        result = 31 * result + (stringCode != null ? stringCode.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "UpdRejectImgDTO{" +
                "recieveData=" + recieveData +
                ", stringCode='" + stringCode + '\'' +
                '}';
    }
}
