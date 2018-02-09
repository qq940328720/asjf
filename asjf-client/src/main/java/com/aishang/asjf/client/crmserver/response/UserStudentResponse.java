package com.aishang.asjf.client.crmserver.response;

import com.aishang.asjf.client.base.CilentBaseResponse;

import java.util.Date;

/**
 * 客户学历实体信息
 * Created by whb on 17-11-10.
 */
public class UserStudentResponse extends CilentBaseResponse {

    private String userCode;//用户编号

    private String studentrecordrace;//民族

    private String studentrecordcollege;//学校

    private String studentrecordenrollmentstatus;//在籍状态

    private String studentrecorddegree;//学历

    private Object studentrecordprogramtype;//几年制


    private String studentrecorddegreeno;//学位号

    private String studentrecordmajor;//专业

    private Date studentrecordregistrationdate;//入学时间

    private String studentrecordstudentno;//学号

    private Date studentgraduationdate;//毕业时间

    private String studentrecordregistrationdateStr;//入学时间

    private String studentgraduationdateStr;//毕业时间

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getStudentrecordrace() {
        return studentrecordrace;
    }

    public void setStudentrecordrace(String studentrecordrace) {
        this.studentrecordrace = studentrecordrace;
    }

    public String getStudentrecordcollege() {
        return studentrecordcollege;
    }

    public void setStudentrecordcollege(String studentrecordcollege) {
        this.studentrecordcollege = studentrecordcollege;
    }

    public String getStudentrecordenrollmentstatus() {
        return studentrecordenrollmentstatus;
    }

    public void setStudentrecordenrollmentstatus(String studentrecordenrollmentstatus) {
        this.studentrecordenrollmentstatus = studentrecordenrollmentstatus;
    }

    public String getStudentrecorddegree() {
        return studentrecorddegree;
    }

    public void setStudentrecorddegree(String studentrecorddegree) {
        this.studentrecorddegree = studentrecorddegree;
    }

    public Object getStudentrecordprogramtype() {
        return studentrecordprogramtype;
    }

    public void setStudentrecordprogramtype(Object studentrecordprogramtype) {
        this.studentrecordprogramtype = studentrecordprogramtype;
    }

    public String getStudentrecorddegreeno() {
        return studentrecorddegreeno;
    }

    public void setStudentrecorddegreeno(String studentrecorddegreeno) {
        this.studentrecorddegreeno = studentrecorddegreeno;
    }

    public String getStudentrecordmajor() {
        return studentrecordmajor;
    }

    public void setStudentrecordmajor(String studentrecordmajor) {
        this.studentrecordmajor = studentrecordmajor;
    }

    public Date getStudentrecordregistrationdate() {
        return studentrecordregistrationdate;
    }

    public void setStudentrecordregistrationdate(Date studentrecordregistrationdate) {
        this.studentrecordregistrationdate = studentrecordregistrationdate;
    }

    public String getStudentrecordstudentno() {
        return studentrecordstudentno;
    }

    public void setStudentrecordstudentno(String studentrecordstudentno) {
        this.studentrecordstudentno = studentrecordstudentno;
    }

    public Date getStudentgraduationdate() {
        return studentgraduationdate;
    }

    public void setStudentgraduationdate(Date studentgraduationdate) {
        this.studentgraduationdate = studentgraduationdate;
    }

    public String getStudentrecordregistrationdateStr() {
        return studentrecordregistrationdateStr;
    }

    public void setStudentrecordregistrationdateStr(String studentrecordregistrationdateStr) {
        this.studentrecordregistrationdateStr = studentrecordregistrationdateStr;
    }

    public String getStudentgraduationdateStr() {
        return studentgraduationdateStr;
    }

    public void setStudentgraduationdateStr(String studentgraduationdateStr) {
        this.studentgraduationdateStr = studentgraduationdateStr;
    }
}
