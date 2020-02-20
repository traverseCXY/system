package com.ssm.dao;

import com.ssm.entity.Student;
import com.ssm.entity.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeacherDao {
    List<Teacher> getTeaByPageHelper(@Param("pageNum")int pageNum, @Param("pageSize")int pageSize);
    void deleteById(int id);
    void insert(Teacher teacher);
    void update(Teacher teacher);
    Teacher getTeacherByNumber(String number);
    void updatePhoto(Teacher teacher);
    void updateByNumber(Teacher teacher);
}
