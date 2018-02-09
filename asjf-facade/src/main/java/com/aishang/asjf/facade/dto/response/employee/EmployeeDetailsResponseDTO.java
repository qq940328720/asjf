package com.aishang.asjf.facade.dto.response.employee;

public class EmployeeDetailsResponseDTO extends EmployeeBaseResponseDTO {

    private String emplCode;
    private String name;
    private String mobilePhone;

    public EmployeeDetailsResponseDTO(String emplCode, String name, String mobilePhone) {
        this.emplCode = emplCode;
        this.name = name;
        this.mobilePhone = mobilePhone;
    }

    public EmployeeDetailsResponseDTO() {

    }

    @Override
    public String toString() {
        return "EmployeeDetailsResponseDTO{" +
                "emplCode='" + emplCode + '\'' +
                ", name='" + name + '\'' +
                ", mobilePhone='" + mobilePhone + '\'' +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmployeeDetailsResponseDTO that = (EmployeeDetailsResponseDTO) o;

        if (emplCode != null ? !emplCode.equals(that.emplCode) : that.emplCode != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        return mobilePhone != null ? mobilePhone.equals(that.mobilePhone) : that.mobilePhone == null;
    }

    @Override
    public int hashCode() {
        int result = emplCode != null ? emplCode.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (mobilePhone != null ? mobilePhone.hashCode() : 0);
        return result;
    }

    public String getEmplCode() {

        return emplCode;
    }

    public void setEmplCode(String emplCode) {
        this.emplCode = emplCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }
}
