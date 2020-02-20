package com.ssm.entity;

import lombok.Data;

import java.util.List;

@Data
public class batchAddStudentVO {

    private List<StudentAddVO> studentList;

    public List<StudentAddVO> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<StudentAddVO> studentList) {
        this.studentList = studentList;
    }
    public batchAddStudentVO( ){
    }
    public batchAddStudentVO(List<StudentAddVO> studentList) {
        this.studentList = studentList;
    }

}
