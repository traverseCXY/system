package com.ssm.entity;

import lombok.Data;

import javax.validation.constraints.Size;

//班级
@Data
public class Clazz {
    private int id;
    @Size(min = 1,max =20,message = "长度不在合理规范内")
    private String name;
    private Grade grade;
    private int gradeid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public int getGradeid() {
        return gradeid;
    }

    public void setGradeid(int gradeid) {
        this.gradeid = gradeid;
    }
}
