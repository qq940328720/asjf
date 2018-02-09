package com.aishang.asjf.client.orderserver.request.PushDataRequest;

/**
 * @Author 李通
 * @Data 17-12-15 上午11:27
 */
public class StudentRecordInfoRequestClient {

    private String race;          // 民族

    private String college;       // 学校

    private String enrollment_status;// 在籍状态

    private String degree;        // 学历

    private String program_type;  // 几年制

    private String degree_no;     // 学位号

    private String major;         // 专业

    private String registration_date; // 入学时间

    private String student_no;        // 学号

    private String graduation_date;   // 毕业时间

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudentRecordInfoRequestClient that = (StudentRecordInfoRequestClient) o;

        if (race != null ? !race.equals(that.race) : that.race != null) return false;
        if (college != null ? !college.equals(that.college) : that.college != null) return false;
        if (enrollment_status != null ? !enrollment_status.equals(that.enrollment_status) : that.enrollment_status != null)
            return false;
        if (degree != null ? !degree.equals(that.degree) : that.degree != null) return false;
        if (program_type != null ? !program_type.equals(that.program_type) : that.program_type != null) return false;
        if (degree_no != null ? !degree_no.equals(that.degree_no) : that.degree_no != null) return false;
        if (major != null ? !major.equals(that.major) : that.major != null) return false;
        if (registration_date != null ? !registration_date.equals(that.registration_date) : that.registration_date != null)
            return false;
        if (student_no != null ? !student_no.equals(that.student_no) : that.student_no != null) return false;
        return graduation_date != null ? graduation_date.equals(that.graduation_date) : that.graduation_date == null;
    }

    @Override
    public int hashCode() {
        int result = race != null ? race.hashCode() : 0;
        result = 31 * result + (college != null ? college.hashCode() : 0);
        result = 31 * result + (enrollment_status != null ? enrollment_status.hashCode() : 0);
        result = 31 * result + (degree != null ? degree.hashCode() : 0);
        result = 31 * result + (program_type != null ? program_type.hashCode() : 0);
        result = 31 * result + (degree_no != null ? degree_no.hashCode() : 0);
        result = 31 * result + (major != null ? major.hashCode() : 0);
        result = 31 * result + (registration_date != null ? registration_date.hashCode() : 0);
        result = 31 * result + (student_no != null ? student_no.hashCode() : 0);
        result = 31 * result + (graduation_date != null ? graduation_date.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "StudentRecordInfoRequestClient{" +
                "race='" + race + '\'' +
                ", college='" + college + '\'' +
                ", enrollment_status='" + enrollment_status + '\'' +
                ", degree='" + degree + '\'' +
                ", program_type='" + program_type + '\'' +
                ", degree_no='" + degree_no + '\'' +
                ", major='" + major + '\'' +
                ", registration_date='" + registration_date + '\'' +
                ", student_no='" + student_no + '\'' +
                ", graduation_date='" + graduation_date + '\'' +
                '}';
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getEnrollment_status() {
        return enrollment_status;
    }

    public void setEnrollment_status(String enrollment_status) {
        this.enrollment_status = enrollment_status;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getProgram_type() {
        return program_type;
    }

    public void setProgram_type(String program_type) {
        this.program_type = program_type;
    }

    public String getDegree_no() {
        return degree_no;
    }

    public void setDegree_no(String degree_no) {
        this.degree_no = degree_no;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getRegistration_date() {
        return registration_date;
    }

    public void setRegistration_date(String registration_date) {
        this.registration_date = registration_date;
    }

    public String getStudent_no() {
        return student_no;
    }

    public void setStudent_no(String student_no) {
        this.student_no = student_no;
    }

    public String getGraduation_date() {
        return graduation_date;
    }

    public void setGraduation_date(String graduation_date) {
        this.graduation_date = graduation_date;
    }
}
