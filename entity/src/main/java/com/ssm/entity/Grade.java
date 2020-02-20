package com.ssm.entity;

import lombok.Data;

import java.util.LinkedList;
import java.util.List;

//年级
@Data
public class Grade {
    private int id;
    private String name;
    private List<Class> clazzList = new LinkedList<>();
    private List<Course> courseList = new LinkedList<>();
    private List<Student> studentList = new LinkedList<>();

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Class> getClazzList() {
        return clazzList;
    }

    public void setClazzList(List<Class> clazzList) {
        this.clazzList = clazzList;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }
}
