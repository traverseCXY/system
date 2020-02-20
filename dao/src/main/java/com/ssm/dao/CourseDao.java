package com.ssm.dao;

import com.ssm.entity.Course;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseDao {
    Course getById(Integer id);
    List<Course> getAll();
    void deleteById(int id);
    void insert(Course course);
    void update(Course course);
    List<Course> getCourseById(int id);
    List<Course> getCourseByTeacherId(int id);
    List<Course> getCourseByGradeId(int gradeid);
}
