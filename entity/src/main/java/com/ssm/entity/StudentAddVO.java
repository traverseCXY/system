package com.ssm.entity;

import lombok.Data;

@Data
public class StudentAddVO {
    private String number;
    private String name;
    private String sex;
    private String phone;
    private String qq;
    private String imgpath;
    private String clazzname;
    private String gradename;
    public StudentAddVO(){}


    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getImgpath() {
        return imgpath;
    }

    public void setImgpath(String imgpath) {
        this.imgpath = imgpath;
    }

    public String getClazzname() {
        return clazzname;
    }

    public void setClazzname(String clazzname) {
        this.clazzname = clazzname;
    }

    public String getGradename() {
        return gradename;
    }

    public void setGradename(String gradename) {
        this.gradename = gradename;
    }

    public StudentAddVO(String number, String name, String sex, String phone, String qq, String imgpath, String clazzname, String gradename) {
        this.number = number;
        this.name = name;
        this.sex = sex;
        this.phone = phone;
        this.qq = qq;
        this.imgpath = imgpath;
        this.clazzname = clazzname;
        this.gradename = gradename;
    }
}
