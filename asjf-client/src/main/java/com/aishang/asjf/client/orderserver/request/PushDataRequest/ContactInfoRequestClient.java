package com.aishang.asjf.client.orderserver.request.PushDataRequest;

public class ContactInfoRequestClient {
    private String firstContactGx;  // 第一联系人关系

    private String firstContactName;          // 第一联系人姓名

    private String firstContactPhone;         // 第一联系人电话

    private String secondContacGx; // 第二联系人关系

    private String secondContactName;         // 第二联系人姓名

    private String secondContactPhone;        // 第二联系人电话

    private String thirdContacGx;  // 第三联系人关系

    private String thirdContactName;          // 第三联系人姓名

    private String thirdContactPhone;         // 第三联系人电话

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactInfoRequestClient that = (ContactInfoRequestClient) o;

        if (firstContactGx != null ? !firstContactGx.equals(that.firstContactGx) : that.firstContactGx != null)
            return false;
        if (firstContactName != null ? !firstContactName.equals(that.firstContactName) : that.firstContactName != null)
            return false;
        if (firstContactPhone != null ? !firstContactPhone.equals(that.firstContactPhone) : that.firstContactPhone != null)
            return false;
        if (secondContacGx != null ? !secondContacGx.equals(that.secondContacGx) : that.secondContacGx != null)
            return false;
        if (secondContactName != null ? !secondContactName.equals(that.secondContactName) : that.secondContactName != null)
            return false;
        if (secondContactPhone != null ? !secondContactPhone.equals(that.secondContactPhone) : that.secondContactPhone != null)
            return false;
        if (thirdContacGx != null ? !thirdContacGx.equals(that.thirdContacGx) : that.thirdContacGx != null)
            return false;
        if (thirdContactName != null ? !thirdContactName.equals(that.thirdContactName) : that.thirdContactName != null)
            return false;
        return thirdContactPhone != null ? thirdContactPhone.equals(that.thirdContactPhone) : that.thirdContactPhone == null;
    }

    @Override
    public int hashCode() {
        int result = firstContactGx != null ? firstContactGx.hashCode() : 0;
        result = 31 * result + (firstContactName != null ? firstContactName.hashCode() : 0);
        result = 31 * result + (firstContactPhone != null ? firstContactPhone.hashCode() : 0);
        result = 31 * result + (secondContacGx != null ? secondContacGx.hashCode() : 0);
        result = 31 * result + (secondContactName != null ? secondContactName.hashCode() : 0);
        result = 31 * result + (secondContactPhone != null ? secondContactPhone.hashCode() : 0);
        result = 31 * result + (thirdContacGx != null ? thirdContacGx.hashCode() : 0);
        result = 31 * result + (thirdContactName != null ? thirdContactName.hashCode() : 0);
        result = 31 * result + (thirdContactPhone != null ? thirdContactPhone.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ContactInfoRequestClient{" +
                "firstContactGx='" + firstContactGx + '\'' +
                ", firstContactName='" + firstContactName + '\'' +
                ", firstContactPhone='" + firstContactPhone + '\'' +
                ", secondContacGx='" + secondContacGx + '\'' +
                ", secondContactName='" + secondContactName + '\'' +
                ", secondContactPhone='" + secondContactPhone + '\'' +
                ", thirdContacGx='" + thirdContacGx + '\'' +
                ", thirdContactName='" + thirdContactName + '\'' +
                ", thirdContactPhone='" + thirdContactPhone + '\'' +
                '}';
    }

    public String getFirstContactGx() {
        return firstContactGx;
    }

    public void setFirstContactGx(String firstContactGx) {
        this.firstContactGx = firstContactGx;
    }

    public String getFirstContactName() {
        return firstContactName;
    }

    public void setFirstContactName(String firstContactName) {
        this.firstContactName = firstContactName;
    }

    public String getFirstContactPhone() {
        return firstContactPhone;
    }

    public void setFirstContactPhone(String firstContactPhone) {
        this.firstContactPhone = firstContactPhone;
    }

    public String getSecondContacGx() {
        return secondContacGx;
    }

    public void setSecondContacGx(String secondContacGx) {
        this.secondContacGx = secondContacGx;
    }

    public String getSecondContactName() {
        return secondContactName;
    }

    public void setSecondContactName(String secondContactName) {
        this.secondContactName = secondContactName;
    }

    public String getSecondContactPhone() {
        return secondContactPhone;
    }

    public void setSecondContactPhone(String secondContactPhone) {
        this.secondContactPhone = secondContactPhone;
    }

    public String getThirdContacGx() {
        return thirdContacGx;
    }

    public void setThirdContacGx(String thirdContacGx) {
        this.thirdContacGx = thirdContacGx;
    }

    public String getThirdContactName() {
        return thirdContactName;
    }

    public void setThirdContactName(String thirdContactName) {
        this.thirdContactName = thirdContactName;
    }

    public String getThirdContactPhone() {
        return thirdContactPhone;
    }

    public void setThirdContactPhone(String thirdContactPhone) {
        this.thirdContactPhone = thirdContactPhone;
    }
}
