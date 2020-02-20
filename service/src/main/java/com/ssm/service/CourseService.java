package com.ssm.service;

import com.ssm.entity.Course;
import com.ssm.entity.EScore;
import com.ssm.entity.Exam;

import java.util.List;

public interface CourseService {
    Course getById(Integer id);
    List<Course> getAll();
    List<Course> getCourseById(int id);
    List<Course> getCourseByTeacherId(int id);
    void deleteById(int id);
    List<Course> getCourseByGradeId(int id);
    void insert(Course course);

}
