package com.ssm.entity;

import lombok.Data;

//学生
@Data
public class Student {
    private Integer id;
    private String number;
    private String name;
    private String sex;
    private String phone;
    private String qq;
    private Clazz clazz;
    private int clazzid;
    private Grade grade;
    private int gradeid;
    private String imgpath;
    private String clazzname;
    private String gradename;

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

    public Student(String number, String name, String sex, String phone, String qq, String imgpath, String clazzname, String gradename) {
        this.number = number;
        this.name = name;
        this.sex = sex;
        this.phone = phone;
        this.qq = qq;
        this.imgpath = imgpath;
        this.clazzname = clazzname;
        this.gradename = gradename;
    }

    public Student(String number, String name, String sex, String phone, String imgpath, String qq, int clazzid, int gradeid) {
        this.number=number;
        this.name=name;
        this.sex=sex;
        this.phone=phone;
        this.imgpath=imgpath;
        this.qq=qq;
        this.clazzid=clazzid;
        this.gradeid=gradeid;
    }

    public Student( ) {
        this.sex = sex;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
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

    public Clazz getClazz() {
        return clazz;
    }

    public void setClazz(Clazz clazz) {
        this.clazz = clazz;
    }

    public int getClazzid() {
        return clazzid;
    }

    public void setClazzid(int clazzid) {
        this.clazzid = clazzid;
    }

    public String getImgpath() {
        return imgpath;
    }

    public void setImgpath(String imgpath) {
        this.imgpath = imgpath;
    }
}
