package com.ssm.service;

import com.ssm.entity.Teacher;

import java.util.List;

public interface TeacherService {
    List<Teacher> getEmpsByPageHelper(int pageNum,int pageSize);
    void deleteById(int id);
    void insert(Teacher teacher);
    void update(Teacher teacher);
    Teacher getTeacherByNumber(String number);
    void updatePhoto(Teacher teacher);
    void updateByNumber(Teacher teacher);
}
