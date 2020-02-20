package com.ssm.dao;

import com.ssm.entity.Student;
import com.ssm.entity.StudentVO;
import jdk.nashorn.api.scripting.ScriptUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentDao {
    List<Student> getStuByPageHelper(int pageNum,int pageSize);
    List<Student> getStuByClazzid(Integer clazzid);
    void update(Student student);
    void insert(StudentVO student);
    void delete(int id);
    Student getById(String number);
    void deleteByGradeId(int id);
    void deleteByClazzId(int id);
    Student getStudentByNumber(String number);
    List<Student> getStuByStuClazzid(int page,int rows,int clazzid);
    void updatePhoto(Student student);
    int count();
    Student getStudentByExamId(int studentid);
}
