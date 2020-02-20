package com.ssm.entity;

import lombok.Data;

@Data
public class Result {

    private Integer id;
    private Integer studentid;
    private Integer examquestionid;
    private String boolresult;

    public Result(Integer studentid, Integer examquestionid, String boolresult) {
        this.studentid = studentid;
        this.examquestionid = examquestionid;
        this.boolresult = boolresult;
    }
}
