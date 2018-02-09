package com.aishang.asjf.client.orderserver.request.PushDataRequest;


//推送数据--银行信息请求对象
public class BankInfoRequestClient {
    private String bankCardNumber;        // 银行卡号

    private int bankId;                   // 银行ID

    private int provinceCode;             // 银行所在地省份ID

    private int cityCode;                 // 银行所在地城市ID

    private int districtCode;             // 银行所在地区域ID

    private String bankPlace;             // 银行所在地

    @Override
    public String toString() {
        return "BankInfoRequestClient{" +
                "bankCardNumber='" + bankCardNumber + '\'' +
                ", bankId=" + bankId +
                ", provinceCode=" + provinceCode +
                ", cityCode=" + cityCode +
                ", districtCode=" + districtCode +
                ", bankPlace='" + bankPlace + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BankInfoRequestClient that = (BankInfoRequestClient) o;

        if (bankId != that.bankId) return false;
        if (provinceCode != that.provinceCode) return false;
        if (cityCode != that.cityCode) return false;
        if (districtCode != that.districtCode) return false;
        if (bankCardNumber != null ? !bankCardNumber.equals(that.bankCardNumber) : that.bankCardNumber != null)
            return false;
        return bankPlace != null ? bankPlace.equals(that.bankPlace) : that.bankPlace == null;
    }

    @Override
    public int hashCode() {
        int result = bankCardNumber != null ? bankCardNumber.hashCode() : 0;
        result = 31 * result + bankId;
        result = 31 * result + provinceCode;
        result = 31 * result + cityCode;
        result = 31 * result + districtCode;
        result = 31 * result + (bankPlace != null ? bankPlace.hashCode() : 0);
        return result;
    }

    public String getBankCardNumber() {
        return bankCardNumber;
    }

    public void setBankCardNumber(String bankCardNumber) {
        this.bankCardNumber = bankCardNumber;
    }

    public int getBankId() {
        return bankId;
    }

    public void setBankId(int bankId) {
        this.bankId = bankId;
    }

    public int getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(int provinceCode) {
        this.provinceCode = provinceCode;
    }

    public int getCityCode() {
        return cityCode;
    }

    public void setCityCode(int cityCode) {
        this.cityCode = cityCode;
    }

    public int getDistrictCode() {
        return districtCode;
    }

    public void setDistrictCode(int districtCode) {
        this.districtCode = districtCode;
    }

    public String getBankPlace() {
        return bankPlace;
    }

    public void setBankPlace(String bankPlace) {
        this.bankPlace = bankPlace;
    }
}
