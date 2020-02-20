package com.ssm.entity;

import lombok.Data;

@Data
public class System {
    private Integer id;

    private String schoolName; //学校名称

    private Integer forbidTeacher; //禁止教师登录系统

    private Integer forbidStudent; //禁止学生登录系统

    private String noticeTeacher; //教师通知

    private String noticeStudent; //学生通知

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public Integer getForbidTeacher() {
        return forbidTeacher;
    }

    public void setForbidTeacher(Integer forbidTeacher) {
        this.forbidTeacher = forbidTeacher;
    }

    public Integer getForbidStudent() {
        return forbidStudent;
    }

    public void setForbidStudent(Integer forbidStudent) {
        this.forbidStudent = forbidStudent;
    }

    public String getNoticeTeacher() {
        return noticeTeacher;
    }

    public void setNoticeTeacher(String noticeTeacher) {
        this.noticeTeacher = noticeTeacher;
    }

    public String getNoticeStudent() {
        return noticeStudent;
    }

    public void setNoticeStudent(String noticeStudent) {
        this.noticeStudent = noticeStudent;
    }
}
