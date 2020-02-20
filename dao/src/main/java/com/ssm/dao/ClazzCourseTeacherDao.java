package com.ssm.dao;

import com.ssm.entity.CourseItem;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ClazzCourseTeacherDao {
    void deleteById(int id);
    void deleteByCourseId(int id);
    List<CourseItem> getClazzCourseTeacherByTeacherId(int id);
    void insert(int gradeid,int clazzid,int courseid,int teacherid);
    void deleteByTeacherId(int id);
    CourseItem getClazzIdByTeacherId(int id);
}
