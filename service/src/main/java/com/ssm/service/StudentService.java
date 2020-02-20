package com.ssm.service;

import com.ssm.entity.Student;
import com.ssm.entity.StudentVO;

import java.util.List;

public interface StudentService {

    List<Student> getStuByPageHalper(Integer pageNum, Integer pageSize);

    Student getById(String id);

    void insert(StudentVO student);

    void delete(int id);

    void update(StudentVO  student);

    List<Student> getStuByClazzid(Integer clazzid);

    void deleteByGradeId(int id);

    void deleteByClazzId(int id);

    Student getStudentByNumber(String number);

    List<Student> getStuByStuClazzid(int page,int rows,int clazzid);

    void updatePhoto(Student student);

    int count();

   Student getStudentByExamId(int examid);

}
