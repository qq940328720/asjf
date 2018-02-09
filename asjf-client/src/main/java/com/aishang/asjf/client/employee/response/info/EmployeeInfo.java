package com.aishang.asjf.client.employee.response.info;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by mx on 17-11-24.
 */
public class EmployeeInfo implements Serializable {

    private String leaderName;

    private String jobSysidStr;

    private Integer id;                        // 编号

    private String employeeCode;                // 用户编码

    private String adminCode;                    // 对应administrator.code

    private String orgCode;                    // 对应 authority_organization.org_code

    private String orgName;

    private String leaderCode;

    private String jobName;

    private String jobCode;

    private BigDecimal jobsalary;

    private Integer jobSysid;                    // 职务-字典id

    private WorkStateEnum workState;            // 工作状态

    private ISDeleteEnum isDelete;

    private String name;                        // 姓名

    private SexEnum sex;                        // 性别 1 男，2 女

    private NationEnum nation;                        // 民族

    private String provinceCode;                // 省

    private String cityCode;                    // 市

    private String districtCode;                // 区

    private PoliticalEnum politicalDentity;            // 政治面貌

    private Timestamp birthday;                // 生日

    private String idcert;                        // 身份证号码

    private ISMarryEnum isMarry;                // 婚否 1 已婚，2 未婚

    private String mobileno;                    // 手机号码

    private String telephone;                    // 宅电及紧急联系人电话

    private Timestamp entryDate;                // 进公司时间

    private Timestamp quitDate;                // 离职时间

    private String address;                    // 家庭住址

    private String hometown;                    // 户口所在地

    private HomeTypeEnum hometownType;                // 户口性质

    private LabourTypeEnum labourType;                    // 用工形式

    private Timestamp workStartDate;            // 参加工作时间

    private String workExperience;                // 工作经历

    private String graduationSchool;            // 统招毕业学校

    private String major;                        // 统招专业

    private EducationEnum education;                    // 统招学历

    private Timestamp graduationDate;            // 统招毕业时间

    private ISHaveEnum accidentInsurance;            // 意外保险

    private List<AttachmentsInfo> otherAgreement;            // 其他协议

    private Timestamp termLaborContract;        // 劳动合同期限

    private Timestamp renewalContractPeriod;    // 续签合同期限

    private String remarks;                    // 备注

    private Timestamp insertTime;                // 创建时间

    private Timestamp updateTime;                // 最后更新时间

    private String bizid;

    private String fileCode;

    private String workStateStr;

    private String isDeleteStr;

    private String auditStateStr;

    private String sexStr;

    private String isMarryStr;

    public String getLeaderName() {
        return leaderName;
    }

    public void setLeaderName(String leaderName) {
        this.leaderName = leaderName;
    }

    public String getJobSysidStr() {
        return jobSysidStr;
    }

    public void setJobSysidStr(String jobSysidStr) {
        this.jobSysidStr = jobSysidStr;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getAdminCode() {
        return adminCode;
    }

    public void setAdminCode(String adminCode) {
        this.adminCode = adminCode;
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getLeaderCode() {
        return leaderCode;
    }

    public void setLeaderCode(String leaderCode) {
        this.leaderCode = leaderCode;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getJobCode() {
        return jobCode;
    }

    public void setJobCode(String jobCode) {
        this.jobCode = jobCode;
    }

    public BigDecimal getJobsalary() {
        return jobsalary;
    }

    public void setJobsalary(BigDecimal jobsalary) {
        this.jobsalary = jobsalary;
    }

    public Integer getJobSysid() {
        return jobSysid;
    }

    public void setJobSysid(Integer jobSysid) {
        this.jobSysid = jobSysid;
    }

    public WorkStateEnum getWorkState() {
        return workState;
    }

    public void setWorkState(WorkStateEnum workState) {
        this.workState = workState;
    }

    public ISDeleteEnum getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(ISDeleteEnum isDelete) {
        this.isDelete = isDelete;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SexEnum getSex() {
        return sex;
    }

    public void setSex(SexEnum sex) {
        this.sex = sex;
    }

    public NationEnum getNation() {
        return nation;
    }

    public void setNation(NationEnum nation) {
        this.nation = nation;
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

    public PoliticalEnum getPoliticalDentity() {
        return politicalDentity;
    }

    public void setPoliticalDentity(PoliticalEnum politicalDentity) {
        this.politicalDentity = politicalDentity;
    }

    public Timestamp getBirthday() {
        return birthday;
    }

    public void setBirthday(Timestamp birthday) {
        this.birthday = birthday;
    }

    public String getIdcert() {
        return idcert;
    }

    public void setIdcert(String idcert) {
        this.idcert = idcert;
    }

    public ISMarryEnum getIsMarry() {
        return isMarry;
    }

    public void setIsMarry(ISMarryEnum isMarry) {
        this.isMarry = isMarry;
    }

    public String getMobileno() {
        return mobileno;
    }

    public void setMobileno(String mobileno) {
        this.mobileno = mobileno;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Timestamp getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Timestamp entryDate) {
        this.entryDate = entryDate;
    }

    public Timestamp getQuitDate() {
        return quitDate;
    }

    public void setQuitDate(Timestamp quitDate) {
        this.quitDate = quitDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getHometown() {
        return hometown;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown;
    }

    public HomeTypeEnum getHometownType() {
        return hometownType;
    }

    public void setHometownType(HomeTypeEnum hometownType) {
        this.hometownType = hometownType;
    }

    public LabourTypeEnum getLabourType() {
        return labourType;
    }

    public void setLabourType(LabourTypeEnum labourType) {
        this.labourType = labourType;
    }

    public Timestamp getWorkStartDate() {
        return workStartDate;
    }

    public void setWorkStartDate(Timestamp workStartDate) {
        this.workStartDate = workStartDate;
    }

    public String getWorkExperience() {
        return workExperience;
    }

    public void setWorkExperience(String workExperience) {
        this.workExperience = workExperience;
    }

    public String getGraduationSchool() {
        return graduationSchool;
    }

    public void setGraduationSchool(String graduationSchool) {
        this.graduationSchool = graduationSchool;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public EducationEnum getEducation() {
        return education;
    }

    public void setEducation(EducationEnum education) {
        this.education = education;
    }

    public Timestamp getGraduationDate() {
        return graduationDate;
    }

    public void setGraduationDate(Timestamp graduationDate) {
        this.graduationDate = graduationDate;
    }

    public ISHaveEnum getAccidentInsurance() {
        return accidentInsurance;
    }

    public void setAccidentInsurance(ISHaveEnum accidentInsurance) {
        this.accidentInsurance = accidentInsurance;
    }

    public List<AttachmentsInfo> getOtherAgreement() {
        return otherAgreement;
    }

    public void setOtherAgreement(List<AttachmentsInfo> otherAgreement) {
        this.otherAgreement = otherAgreement;
    }

    public Timestamp getTermLaborContract() {
        return termLaborContract;
    }

    public void setTermLaborContract(Timestamp termLaborContract) {
        this.termLaborContract = termLaborContract;
    }

    public Timestamp getRenewalContractPeriod() {
        return renewalContractPeriod;
    }

    public void setRenewalContractPeriod(Timestamp renewalContractPeriod) {
        this.renewalContractPeriod = renewalContractPeriod;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Timestamp getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(Timestamp insertTime) {
        this.insertTime = insertTime;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public String getBizid() {
        return bizid;
    }

    public void setBizid(String bizid) {
        this.bizid = bizid;
    }

    public String getFileCode() {
        return fileCode;
    }

    public void setFileCode(String fileCode) {
        this.fileCode = fileCode;
    }

    public String getWorkStateStr() {
        return workStateStr;
    }

    public void setWorkStateStr(String workStateStr) {
        this.workStateStr = workStateStr;
    }

    public String getIsDeleteStr() {
        return isDeleteStr;
    }

    public void setIsDeleteStr(String isDeleteStr) {
        this.isDeleteStr = isDeleteStr;
    }

    public String getAuditStateStr() {
        return auditStateStr;
    }

    public void setAuditStateStr(String auditStateStr) {
        this.auditStateStr = auditStateStr;
    }

    public String getSexStr() {
        return sexStr;
    }

    public void setSexStr(String sexStr) {
        this.sexStr = sexStr;
    }

    public String getIsMarryStr() {
        return isMarryStr;
    }

    public void setIsMarryStr(String isMarryStr) {
        this.isMarryStr = isMarryStr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmployeeInfo that = (EmployeeInfo) o;

        if (leaderName != null ? !leaderName.equals(that.leaderName) : that.leaderName != null) return false;
        if (jobSysidStr != null ? !jobSysidStr.equals(that.jobSysidStr) : that.jobSysidStr != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (employeeCode != null ? !employeeCode.equals(that.employeeCode) : that.employeeCode != null) return false;
        if (adminCode != null ? !adminCode.equals(that.adminCode) : that.adminCode != null) return false;
        if (orgCode != null ? !orgCode.equals(that.orgCode) : that.orgCode != null) return false;
        if (orgName != null ? !orgName.equals(that.orgName) : that.orgName != null) return false;
        if (leaderCode != null ? !leaderCode.equals(that.leaderCode) : that.leaderCode != null) return false;
        if (jobName != null ? !jobName.equals(that.jobName) : that.jobName != null) return false;
        if (jobCode != null ? !jobCode.equals(that.jobCode) : that.jobCode != null) return false;
        if (jobsalary != null ? !jobsalary.equals(that.jobsalary) : that.jobsalary != null) return false;
        if (jobSysid != null ? !jobSysid.equals(that.jobSysid) : that.jobSysid != null) return false;
        if (workState != null ? !workState.equals(that.workState) : that.workState != null) return false;
        if (isDelete != null ? !isDelete.equals(that.isDelete) : that.isDelete != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (sex != null ? !sex.equals(that.sex) : that.sex != null) return false;
        if (nation != null ? !nation.equals(that.nation) : that.nation != null) return false;
        if (provinceCode != null ? !provinceCode.equals(that.provinceCode) : that.provinceCode != null) return false;
        if (cityCode != null ? !cityCode.equals(that.cityCode) : that.cityCode != null) return false;
        if (districtCode != null ? !districtCode.equals(that.districtCode) : that.districtCode != null) return false;
        if (politicalDentity != null ? !politicalDentity.equals(that.politicalDentity) : that.politicalDentity != null)
            return false;
        if (birthday != null ? !birthday.equals(that.birthday) : that.birthday != null) return false;
        if (idcert != null ? !idcert.equals(that.idcert) : that.idcert != null) return false;
        if (isMarry != null ? !isMarry.equals(that.isMarry) : that.isMarry != null) return false;
        if (mobileno != null ? !mobileno.equals(that.mobileno) : that.mobileno != null) return false;
        if (telephone != null ? !telephone.equals(that.telephone) : that.telephone != null) return false;
        if (entryDate != null ? !entryDate.equals(that.entryDate) : that.entryDate != null) return false;
        if (quitDate != null ? !quitDate.equals(that.quitDate) : that.quitDate != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (hometown != null ? !hometown.equals(that.hometown) : that.hometown != null) return false;
        if (hometownType != null ? !hometownType.equals(that.hometownType) : that.hometownType != null) return false;
        if (labourType != null ? !labourType.equals(that.labourType) : that.labourType != null) return false;
        if (workStartDate != null ? !workStartDate.equals(that.workStartDate) : that.workStartDate != null)
            return false;
        if (workExperience != null ? !workExperience.equals(that.workExperience) : that.workExperience != null)
            return false;
        if (graduationSchool != null ? !graduationSchool.equals(that.graduationSchool) : that.graduationSchool != null)
            return false;
        if (major != null ? !major.equals(that.major) : that.major != null) return false;
        if (education != null ? !education.equals(that.education) : that.education != null) return false;
        if (graduationDate != null ? !graduationDate.equals(that.graduationDate) : that.graduationDate != null)
            return false;
        if (accidentInsurance != null ? !accidentInsurance.equals(that.accidentInsurance) : that.accidentInsurance != null)
            return false;
        if (otherAgreement != null ? !otherAgreement.equals(that.otherAgreement) : that.otherAgreement != null)
            return false;
        if (termLaborContract != null ? !termLaborContract.equals(that.termLaborContract) : that.termLaborContract != null)
            return false;
        if (renewalContractPeriod != null ? !renewalContractPeriod.equals(that.renewalContractPeriod) : that.renewalContractPeriod != null)
            return false;
        if (remarks != null ? !remarks.equals(that.remarks) : that.remarks != null) return false;
        if (insertTime != null ? !insertTime.equals(that.insertTime) : that.insertTime != null) return false;
        if (updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null) return false;
        if (bizid != null ? !bizid.equals(that.bizid) : that.bizid != null) return false;
        if (fileCode != null ? !fileCode.equals(that.fileCode) : that.fileCode != null) return false;
        if (workStateStr != null ? !workStateStr.equals(that.workStateStr) : that.workStateStr != null) return false;
        if (isDeleteStr != null ? !isDeleteStr.equals(that.isDeleteStr) : that.isDeleteStr != null) return false;
        if (auditStateStr != null ? !auditStateStr.equals(that.auditStateStr) : that.auditStateStr != null)
            return false;
        if (sexStr != null ? !sexStr.equals(that.sexStr) : that.sexStr != null) return false;
        return isMarryStr != null ? isMarryStr.equals(that.isMarryStr) : that.isMarryStr == null;
    }

    @Override
    public int hashCode() {
        int result = leaderName != null ? leaderName.hashCode() : 0;
        result = 31 * result + (jobSysidStr != null ? jobSysidStr.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (employeeCode != null ? employeeCode.hashCode() : 0);
        result = 31 * result + (adminCode != null ? adminCode.hashCode() : 0);
        result = 31 * result + (orgCode != null ? orgCode.hashCode() : 0);
        result = 31 * result + (orgName != null ? orgName.hashCode() : 0);
        result = 31 * result + (leaderCode != null ? leaderCode.hashCode() : 0);
        result = 31 * result + (jobName != null ? jobName.hashCode() : 0);
        result = 31 * result + (jobCode != null ? jobCode.hashCode() : 0);
        result = 31 * result + (jobsalary != null ? jobsalary.hashCode() : 0);
        result = 31 * result + (jobSysid != null ? jobSysid.hashCode() : 0);
        result = 31 * result + (workState != null ? workState.hashCode() : 0);
        result = 31 * result + (isDelete != null ? isDelete.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        result = 31 * result + (nation != null ? nation.hashCode() : 0);
        result = 31 * result + (provinceCode != null ? provinceCode.hashCode() : 0);
        result = 31 * result + (cityCode != null ? cityCode.hashCode() : 0);
        result = 31 * result + (districtCode != null ? districtCode.hashCode() : 0);
        result = 31 * result + (politicalDentity != null ? politicalDentity.hashCode() : 0);
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        result = 31 * result + (idcert != null ? idcert.hashCode() : 0);
        result = 31 * result + (isMarry != null ? isMarry.hashCode() : 0);
        result = 31 * result + (mobileno != null ? mobileno.hashCode() : 0);
        result = 31 * result + (telephone != null ? telephone.hashCode() : 0);
        result = 31 * result + (entryDate != null ? entryDate.hashCode() : 0);
        result = 31 * result + (quitDate != null ? quitDate.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (hometown != null ? hometown.hashCode() : 0);
        result = 31 * result + (hometownType != null ? hometownType.hashCode() : 0);
        result = 31 * result + (labourType != null ? labourType.hashCode() : 0);
        result = 31 * result + (workStartDate != null ? workStartDate.hashCode() : 0);
        result = 31 * result + (workExperience != null ? workExperience.hashCode() : 0);
        result = 31 * result + (graduationSchool != null ? graduationSchool.hashCode() : 0);
        result = 31 * result + (major != null ? major.hashCode() : 0);
        result = 31 * result + (education != null ? education.hashCode() : 0);
        result = 31 * result + (graduationDate != null ? graduationDate.hashCode() : 0);
        result = 31 * result + (accidentInsurance != null ? accidentInsurance.hashCode() : 0);
        result = 31 * result + (otherAgreement != null ? otherAgreement.hashCode() : 0);
        result = 31 * result + (termLaborContract != null ? termLaborContract.hashCode() : 0);
        result = 31 * result + (renewalContractPeriod != null ? renewalContractPeriod.hashCode() : 0);
        result = 31 * result + (remarks != null ? remarks.hashCode() : 0);
        result = 31 * result + (insertTime != null ? insertTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        result = 31 * result + (bizid != null ? bizid.hashCode() : 0);
        result = 31 * result + (fileCode != null ? fileCode.hashCode() : 0);
        result = 31 * result + (workStateStr != null ? workStateStr.hashCode() : 0);
        result = 31 * result + (isDeleteStr != null ? isDeleteStr.hashCode() : 0);
        result = 31 * result + (auditStateStr != null ? auditStateStr.hashCode() : 0);
        result = 31 * result + (sexStr != null ? sexStr.hashCode() : 0);
        result = 31 * result + (isMarryStr != null ? isMarryStr.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "EmployeeInfo{" +
                "leaderName='" + leaderName + '\'' +
                ", jobSysidStr='" + jobSysidStr + '\'' +
                ", id=" + id +
                ", employeeCode='" + employeeCode + '\'' +
                ", adminCode='" + adminCode + '\'' +
                ", orgCode='" + orgCode + '\'' +
                ", orgName='" + orgName + '\'' +
                ", leaderCode='" + leaderCode + '\'' +
                ", jobName='" + jobName + '\'' +
                ", jobCode='" + jobCode + '\'' +
                ", jobsalary=" + jobsalary +
                ", jobSysid=" + jobSysid +
                ", workState=" + workState +
                ", isDelete=" + isDelete +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", nation=" + nation +
                ", provinceCode='" + provinceCode + '\'' +
                ", cityCode='" + cityCode + '\'' +
                ", districtCode='" + districtCode + '\'' +
                ", politicalDentity=" + politicalDentity +
                ", birthday=" + birthday +
                ", idcert='" + idcert + '\'' +
                ", isMarry=" + isMarry +
                ", mobileno='" + mobileno + '\'' +
                ", telephone='" + telephone + '\'' +
                ", entryDate=" + entryDate +
                ", quitDate=" + quitDate +
                ", address='" + address + '\'' +
                ", hometown='" + hometown + '\'' +
                ", hometownType=" + hometownType +
                ", labourType=" + labourType +
                ", workStartDate=" + workStartDate +
                ", workExperience='" + workExperience + '\'' +
                ", graduationSchool='" + graduationSchool + '\'' +
                ", major='" + major + '\'' +
                ", education=" + education +
                ", graduationDate=" + graduationDate +
                ", accidentInsurance=" + accidentInsurance +
                ", otherAgreement=" + otherAgreement +
                ", termLaborContract=" + termLaborContract +
                ", renewalContractPeriod=" + renewalContractPeriod +
                ", remarks='" + remarks + '\'' +
                ", insertTime=" + insertTime +
                ", updateTime=" + updateTime +
                ", bizid='" + bizid + '\'' +
                ", fileCode='" + fileCode + '\'' +
                ", workStateStr='" + workStateStr + '\'' +
                ", isDeleteStr='" + isDeleteStr + '\'' +
                ", auditStateStr='" + auditStateStr + '\'' +
                ", sexStr='" + sexStr + '\'' +
                ", isMarryStr='" + isMarryStr + '\'' +
                '}';
    }
}
