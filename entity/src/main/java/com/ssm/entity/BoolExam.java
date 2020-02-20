package com.ssm.entity;

import lombok.Data;

@Data
public class BoolExam {

    private Integer examid;

    private String aBoolean;

    public BoolExam(int examid) {
        this.examid = examid;
    }

    public Integer getExamid() {
        return examid;
    }

    public void setExamid(Integer examid) {
        this.examid = examid;
    }


    public String getaBoolean() {
        return aBoolean;
    }

    public void setaBoolean(String aBoolean) {
        this.aBoolean = aBoolean;
    }

}
