package com.aishang.asjf.client.orderserver.response;

import java.io.Serializable;
import java.math.BigDecimal;

public class OrderDataManagerResponse implements Serializable {

    private Integer id;//编号

    private String orderCode;//订单编码

    private String userCode;//客户编号

    private String orgCode;//机构编码

    private String orgName;//机构名

    private String merchantCode;//商户编码

    private String merchantName;//商户名

    private String storeCode;//门店编码

    private String storeName;//门店名

    private String productCode;//产品编码

    private String productName;//产品名

    private String commodityCode;//商品编码

    private String commodityName;//商品名称

    private String level1Code;//级别1 对应字典表产品类目描述

    private String level2Code;//级别2 对应字典表产品类目描述

    private String level3Code;//级别3 对应字典表产品类目描述

    private String userName;//姓名

    private String userPhone;//手机号码

    private String userNationalid;//身份证号码

    private String userGender;//客户性别

    private String empNameCode;//业务员

    private String provinceCode;//省

    private String cityCode;//市

    private String districtCode;//区

    private String homeAddress;//详细地址

    private String lng;//经度

    private String lat;//纬度

    private BigDecimal loanMoney;//贷款金额

    private BigDecimal firstPayMoney;//首付金额

    private BigDecimal commodityPrice;//商品价格

    private Integer interestType;//计息方式 1.等额本息 2.等额本金 3.等本等息

    private Integer payTime;//期数

    private Integer payTimeUnit;//期数单位

    private BigDecimal payRate;//利率

    private Integer moneyResource;//资金通道 1,爱尚   2,小雨点  3,西藏信托

    private String bankCard;//银行卡号

    private String bankName;//银行名称

    private Integer state;//订单状态 1,资料填写中 2,已提交,待信审 3,信审中 4,信审通过,待提货 5,提货完成,待打款 6,还款中 7,已取消 8,已完成

    private Integer orderAuditState;//信审结果 1,待审核  2,审核通过 3,审核拒绝

    private Integer imgAuditState;//提货照审核结果  1,待审核  2,审核通过 3,审核拒绝

    private Integer sendAuditState;//打款结果 1,待放款 2,放款通过 3,放款拒绝

    private Integer finalLoanType;//最终放款对象 1,个人用户 2,商户用户

    private Integer payDay;//还款日

    private Integer clientResource;//终端来源 1,android  2,ios

    private Integer isQuickPayPackage;//是否有提前还款包  0,否  1,是

    private String uniqueCode;//消费贷设备唯一识别码

    private int deleted;//是否删除 1y 0n

    private Long insertTime;//创建时间

    private Long updateTime;//最后更新时间

    private String bizid;//业务id

    private String authCode;//运营商授权编号

    private String ipSrc;//源IP

    private Integer recieveType;//打款方式 1.自动打款 2.线上人工代发 3.线下人工打款

    private Integer recieveState;//打款状态：１、待打款　２、打款成功　３、打款失败　４、打款中

    private Integer isAuth;//是否运营商授权 1 是 0 否

    private Integer isTelephonedirectory;//是否上传通讯录 1 是 0 否

    public Integer getIsAuth() {
        return isAuth;
    }

    public void setIsAuth(Integer isAuth) {
        this.isAuth = isAuth;
    }

    public Integer getIsTelephonedirectory() {
        return isTelephonedirectory;
    }

    public void setIsTelephonedirectory(Integer isTelephonedirectory) {
        this.isTelephonedirectory = isTelephonedirectory;
    }

    public Integer getRecieveState() {
        return recieveState;
    }

    public void setRecieveState(Integer recieveState) {
        this.recieveState = recieveState;
    }

    public Integer getRecieveType() {
        return recieveType;
    }

    public void setRecieveType(Integer recieveType) {
        this.recieveType = recieveType;
    }

    public String getIpSrc() {
        return ipSrc;
    }

    public void setIpSrc(String ipSrc) {
        this.ipSrc = ipSrc;
    }

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

    public String getUniqueCode() {
        return uniqueCode;
    }

    public void setUniqueCode(String uniqueCode) {
        this.uniqueCode = uniqueCode;
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getDistrictCode() {
        return districtCode;
    }

    public void setDistrictCode(String districtCode) {
        this.districtCode = districtCode;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public Integer getPayTimeUnit() {
        return payTimeUnit;
    }

    public void setPayTimeUnit(Integer payTimeUnit) {
        this.payTimeUnit = payTimeUnit;
    }

    public Integer getId() {
        return id;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public String getUserCode() {
        return userCode;
    }

    public String getOrgCode() {
        return orgCode;
    }

    public String getOrgName() {
        return orgName;
    }

    public String getMerchantCode() {
        return merchantCode;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public String getStoreCode() {
        return storeCode;
    }

    public String getStoreName() {
        return storeName;
    }

    public String getProductCode() {
        return productCode;
    }

    public String getProductName() {
        return productName;
    }

    public String getCommodityCode() {
        return commodityCode;
    }

    public String getCommodityName() {
        return commodityName;
    }

    public String getLevel1Code() {
        return level1Code;
    }

    public String getLevel2Code() {
        return level2Code;
    }

    public String getLevel3Code() {
        return level3Code;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public String getUserNationalid() {
        return userNationalid;
    }

    public String getUserGender() {
        return userGender;
    }

    public String getEmpNameCode() {
        return empNameCode;
    }

    public String getLng() {
        return lng;
    }

    public String getLat() {
        return lat;
    }

    public BigDecimal getLoanMoney() {
        return loanMoney;
    }

    public BigDecimal getFirstPayMoney() {
        return firstPayMoney;
    }

    public BigDecimal getCommodityPrice() {
        return commodityPrice;
    }

    public Integer getInterestType() {
        return interestType;
    }

    public Integer getPayTime() {
        return payTime;
    }

    public BigDecimal getPayRate() {
        return payRate;
    }

    public Integer getMoneyResource() {
        return moneyResource;
    }

    public String getBankCard() {
        return bankCard;
    }

    public String getBankName() {
        return bankName;
    }

    public Integer getState() {
        return state;
    }

    public Integer getOrderAuditState() {
        return orderAuditState;
    }

    public Integer getImgAuditState() {
        return imgAuditState;
    }

    public Integer getSendAuditState() {
        return sendAuditState;
    }

    public Integer getFinalLoanType() {
        return finalLoanType;
    }

    public Integer getPayDay() {
        return payDay;
    }

    public Integer getClientResource() {
        return clientResource;
    }

    public Integer getIsQuickPayPackage() {
        return isQuickPayPackage;
    }

    public int getDeleted() {
        return deleted;
    }

    public Long getInsertTime() {
        return insertTime;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public String getBizid() {
        return bizid;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public void setMerchantCode(String merchantCode) {
        this.merchantCode = merchantCode;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public void setStoreCode(String storeCode) {
        this.storeCode = storeCode;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setCommodityCode(String commodityCode) {
        this.commodityCode = commodityCode;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }

    public void setLevel1Code(String level1Code) {
        this.level1Code = level1Code;
    }

    public void setLevel2Code(String level2Code) {
        this.level2Code = level2Code;
    }

    public void setLevel3Code(String level3Code) {
        this.level3Code = level3Code;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public void setUserNationalid(String userNationalid) {
        this.userNationalid = userNationalid;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }

    public void setEmpNameCode(String empNameCode) {
        this.empNameCode = empNameCode;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public void setLoanMoney(BigDecimal loanMoney) {
        this.loanMoney = loanMoney;
    }

    public void setFirstPayMoney(BigDecimal firstPayMoney) {
        this.firstPayMoney = firstPayMoney;
    }

    public void setCommodityPrice(BigDecimal commodityPrice) {
        this.commodityPrice = commodityPrice;
    }

    public void setInterestType(Integer interestType) {
        this.interestType = interestType;
    }

    public void setPayTime(Integer payTime) {
        this.payTime = payTime;
    }

    public void setPayRate(BigDecimal payRate) {
        this.payRate = payRate;
    }

    public void setMoneyResource(Integer moneyResource) {
        this.moneyResource = moneyResource;
    }

    public void setBankCard(String bankCard) {
        this.bankCard = bankCard;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public void setOrderAuditState(Integer orderAuditState) {
        this.orderAuditState = orderAuditState;
    }

    public void setImgAuditState(Integer imgAuditState) {
        this.imgAuditState = imgAuditState;
    }

    public void setSendAuditState(Integer sendAuditState) {
        this.sendAuditState = sendAuditState;
    }

    public void setFinalLoanType(Integer finalLoanType) {
        this.finalLoanType = finalLoanType;
    }

    public void setPayDay(Integer payDay) {
        this.payDay = payDay;
    }

    public void setClientResource(Integer clientResource) {
        this.clientResource = clientResource;
    }

    public void setIsQuickPayPackage(Integer isQuickPayPackage) {
        this.isQuickPayPackage = isQuickPayPackage;
    }

    public void setDeleted(int deleted) {
        this.deleted = deleted;
    }

    public void setInsertTime(Long insertTime) {
        this.insertTime = insertTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    public void setBizid(String bizid) {
        this.bizid = bizid;
    }

    @Override
    public String toString() {
        return "OrderManager{" +
                "id=" + id +
                ", orderCode='" + orderCode + '\'' +
                ", userCode='" + userCode + '\'' +
                ", orgCode='" + orgCode + '\'' +
                ", orgName='" + orgName + '\'' +
                ", merchantCode='" + merchantCode + '\'' +
                ", merchantName='" + merchantName + '\'' +
                ", storeCode='" + storeCode + '\'' +
                ", storeName='" + storeName + '\'' +
                ", productCode='" + productCode + '\'' +
                ", productName='" + productName + '\'' +
                ", commodityCode='" + commodityCode + '\'' +
                ", commodityName='" + commodityName + '\'' +
                ", level1Code='" + level1Code + '\'' +
                ", level2Code='" + level2Code + '\'' +
                ", level3Code='" + level3Code + '\'' +
                ", userName='" + userName + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", userNationalid='" + userNationalid + '\'' +
                ", userGender='" + userGender + '\'' +
                ", empNameCode='" + empNameCode + '\'' +
                ", lng='" + lng + '\'' +
                ", lat='" + lat + '\'' +
                ", loanMoney=" + loanMoney +
                ", firstPayMoney=" + firstPayMoney +
                ", commodityPrice=" + commodityPrice +
                ", interestType=" + interestType +
                ", payTime=" + payTime +
                ", payTimeUnit=" + payTimeUnit +
                ", payRate=" + payRate +
                ", moneyResource=" + moneyResource +
                ", bankCard='" + bankCard + '\'' +
                ", bankName='" + bankName + '\'' +
                ", state=" + state +
                ", orderAuditState=" + orderAuditState +
                ", imgAuditState=" + imgAuditState +
                ", sendAuditState=" + sendAuditState +
                ", finalLoanType=" + finalLoanType +
                ", payDay=" + payDay +
                ", clientResource=" + clientResource +
                ", isQuickPayPackage=" + isQuickPayPackage +
                ", deleted=" + deleted +
                ", insertTime=" + insertTime +
                ", updateTime=" + updateTime +
                ", bizid='" + bizid + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderDataManagerResponse that = (OrderDataManagerResponse) o;

        if (deleted != that.deleted) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (orderCode != null ? !orderCode.equals(that.orderCode) : that.orderCode != null) return false;
        if (userCode != null ? !userCode.equals(that.userCode) : that.userCode != null) return false;
        if (orgCode != null ? !orgCode.equals(that.orgCode) : that.orgCode != null) return false;
        if (orgName != null ? !orgName.equals(that.orgName) : that.orgName != null) return false;
        if (merchantCode != null ? !merchantCode.equals(that.merchantCode) : that.merchantCode != null) return false;
        if (merchantName != null ? !merchantName.equals(that.merchantName) : that.merchantName != null) return false;
        if (storeCode != null ? !storeCode.equals(that.storeCode) : that.storeCode != null) return false;
        if (storeName != null ? !storeName.equals(that.storeName) : that.storeName != null) return false;
        if (productCode != null ? !productCode.equals(that.productCode) : that.productCode != null) return false;
        if (productName != null ? !productName.equals(that.productName) : that.productName != null) return false;
        if (commodityCode != null ? !commodityCode.equals(that.commodityCode) : that.commodityCode != null)
            return false;
        if (commodityName != null ? !commodityName.equals(that.commodityName) : that.commodityName != null)
            return false;
        if (level1Code != null ? !level1Code.equals(that.level1Code) : that.level1Code != null) return false;
        if (level2Code != null ? !level2Code.equals(that.level2Code) : that.level2Code != null) return false;
        if (level3Code != null ? !level3Code.equals(that.level3Code) : that.level3Code != null) return false;
        if (userName != null ? !userName.equals(that.userName) : that.userName != null) return false;
        if (userPhone != null ? !userPhone.equals(that.userPhone) : that.userPhone != null) return false;
        if (userNationalid != null ? !userNationalid.equals(that.userNationalid) : that.userNationalid != null)
            return false;
        if (userGender != null ? !userGender.equals(that.userGender) : that.userGender != null) return false;
        if (empNameCode != null ? !empNameCode.equals(that.empNameCode) : that.empNameCode != null) return false;
        if (provinceCode != null ? !provinceCode.equals(that.provinceCode) : that.provinceCode != null) return false;
        if (cityCode != null ? !cityCode.equals(that.cityCode) : that.cityCode != null) return false;
        if (districtCode != null ? !districtCode.equals(that.districtCode) : that.districtCode != null) return false;
        if (homeAddress != null ? !homeAddress.equals(that.homeAddress) : that.homeAddress != null) return false;
        if (lng != null ? !lng.equals(that.lng) : that.lng != null) return false;
        if (lat != null ? !lat.equals(that.lat) : that.lat != null) return false;
        if (loanMoney != null ? !loanMoney.equals(that.loanMoney) : that.loanMoney != null) return false;
        if (firstPayMoney != null ? !firstPayMoney.equals(that.firstPayMoney) : that.firstPayMoney != null)
            return false;
        if (commodityPrice != null ? !commodityPrice.equals(that.commodityPrice) : that.commodityPrice != null)
            return false;
        if (interestType != null ? !interestType.equals(that.interestType) : that.interestType != null) return false;
        if (payTime != null ? !payTime.equals(that.payTime) : that.payTime != null) return false;
        if (payTimeUnit != null ? !payTimeUnit.equals(that.payTimeUnit) : that.payTimeUnit != null) return false;
        if (payRate != null ? !payRate.equals(that.payRate) : that.payRate != null) return false;
        if (moneyResource != null ? !moneyResource.equals(that.moneyResource) : that.moneyResource != null)
            return false;
        if (bankCard != null ? !bankCard.equals(that.bankCard) : that.bankCard != null) return false;
        if (bankName != null ? !bankName.equals(that.bankName) : that.bankName != null) return false;
        if (state != null ? !state.equals(that.state) : that.state != null) return false;
        if (orderAuditState != null ? !orderAuditState.equals(that.orderAuditState) : that.orderAuditState != null)
            return false;
        if (imgAuditState != null ? !imgAuditState.equals(that.imgAuditState) : that.imgAuditState != null)
            return false;
        if (sendAuditState != null ? !sendAuditState.equals(that.sendAuditState) : that.sendAuditState != null)
            return false;
        if (finalLoanType != null ? !finalLoanType.equals(that.finalLoanType) : that.finalLoanType != null)
            return false;
        if (payDay != null ? !payDay.equals(that.payDay) : that.payDay != null) return false;
        if (clientResource != null ? !clientResource.equals(that.clientResource) : that.clientResource != null)
            return false;
        if (isQuickPayPackage != null ? !isQuickPayPackage.equals(that.isQuickPayPackage) : that.isQuickPayPackage != null)
            return false;
        if (uniqueCode != null ? !uniqueCode.equals(that.uniqueCode) : that.uniqueCode != null) return false;
        if (insertTime != null ? !insertTime.equals(that.insertTime) : that.insertTime != null) return false;
        if (updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null) return false;
        if (bizid != null ? !bizid.equals(that.bizid) : that.bizid != null) return false;
        if (authCode != null ? !authCode.equals(that.authCode) : that.authCode != null) return false;
        if (ipSrc != null ? !ipSrc.equals(that.ipSrc) : that.ipSrc != null) return false;
        if (recieveType != null ? !recieveType.equals(that.recieveType) : that.recieveType != null) return false;
        if (recieveState != null ? !recieveState.equals(that.recieveState) : that.recieveState != null) return false;
        if (isAuth != null ? !isAuth.equals(that.isAuth) : that.isAuth != null) return false;
        return isTelephonedirectory != null ? isTelephonedirectory.equals(that.isTelephonedirectory) : that.isTelephonedirectory == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (orderCode != null ? orderCode.hashCode() : 0);
        result = 31 * result + (userCode != null ? userCode.hashCode() : 0);
        result = 31 * result + (orgCode != null ? orgCode.hashCode() : 0);
        result = 31 * result + (orgName != null ? orgName.hashCode() : 0);
        result = 31 * result + (merchantCode != null ? merchantCode.hashCode() : 0);
        result = 31 * result + (merchantName != null ? merchantName.hashCode() : 0);
        result = 31 * result + (storeCode != null ? storeCode.hashCode() : 0);
        result = 31 * result + (storeName != null ? storeName.hashCode() : 0);
        result = 31 * result + (productCode != null ? productCode.hashCode() : 0);
        result = 31 * result + (productName != null ? productName.hashCode() : 0);
        result = 31 * result + (commodityCode != null ? commodityCode.hashCode() : 0);
        result = 31 * result + (commodityName != null ? commodityName.hashCode() : 0);
        result = 31 * result + (level1Code != null ? level1Code.hashCode() : 0);
        result = 31 * result + (level2Code != null ? level2Code.hashCode() : 0);
        result = 31 * result + (level3Code != null ? level3Code.hashCode() : 0);
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (userPhone != null ? userPhone.hashCode() : 0);
        result = 31 * result + (userNationalid != null ? userNationalid.hashCode() : 0);
        result = 31 * result + (userGender != null ? userGender.hashCode() : 0);
        result = 31 * result + (empNameCode != null ? empNameCode.hashCode() : 0);
        result = 31 * result + (provinceCode != null ? provinceCode.hashCode() : 0);
        result = 31 * result + (cityCode != null ? cityCode.hashCode() : 0);
        result = 31 * result + (districtCode != null ? districtCode.hashCode() : 0);
        result = 31 * result + (homeAddress != null ? homeAddress.hashCode() : 0);
        result = 31 * result + (lng != null ? lng.hashCode() : 0);
        result = 31 * result + (lat != null ? lat.hashCode() : 0);
        result = 31 * result + (loanMoney != null ? loanMoney.hashCode() : 0);
        result = 31 * result + (firstPayMoney != null ? firstPayMoney.hashCode() : 0);
        result = 31 * result + (commodityPrice != null ? commodityPrice.hashCode() : 0);
        result = 31 * result + (interestType != null ? interestType.hashCode() : 0);
        result = 31 * result + (payTime != null ? payTime.hashCode() : 0);
        result = 31 * result + (payTimeUnit != null ? payTimeUnit.hashCode() : 0);
        result = 31 * result + (payRate != null ? payRate.hashCode() : 0);
        result = 31 * result + (moneyResource != null ? moneyResource.hashCode() : 0);
        result = 31 * result + (bankCard != null ? bankCard.hashCode() : 0);
        result = 31 * result + (bankName != null ? bankName.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (orderAuditState != null ? orderAuditState.hashCode() : 0);
        result = 31 * result + (imgAuditState != null ? imgAuditState.hashCode() : 0);
        result = 31 * result + (sendAuditState != null ? sendAuditState.hashCode() : 0);
        result = 31 * result + (finalLoanType != null ? finalLoanType.hashCode() : 0);
        result = 31 * result + (payDay != null ? payDay.hashCode() : 0);
        result = 31 * result + (clientResource != null ? clientResource.hashCode() : 0);
        result = 31 * result + (isQuickPayPackage != null ? isQuickPayPackage.hashCode() : 0);
        result = 31 * result + (uniqueCode != null ? uniqueCode.hashCode() : 0);
        result = 31 * result + deleted;
        result = 31 * result + (insertTime != null ? insertTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        result = 31 * result + (bizid != null ? bizid.hashCode() : 0);
        result = 31 * result + (authCode != null ? authCode.hashCode() : 0);
        result = 31 * result + (ipSrc != null ? ipSrc.hashCode() : 0);
        result = 31 * result + (recieveType != null ? recieveType.hashCode() : 0);
        result = 31 * result + (recieveState != null ? recieveState.hashCode() : 0);
        result = 31 * result + (isAuth != null ? isAuth.hashCode() : 0);
        result = 31 * result + (isTelephonedirectory != null ? isTelephonedirectory.hashCode() : 0);
        return result;
    }
}