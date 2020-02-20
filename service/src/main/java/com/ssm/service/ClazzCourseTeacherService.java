package com.ssm.service;

import com.ssm.entity.CourseItem;

import java.util.List;

public interface ClazzCourseTeacherService {
    void deleteById(int id);
    void deleteByCourseId(int id);
    List<CourseItem> getClazzCourseTeacherByTeacherId(int id);
    void insert(int gradeid,int clazzid,int courseid,int teacherid);
    void deleteByTeacher(int id);
    CourseItem getClazzIdByTeacherId(int id);
}
