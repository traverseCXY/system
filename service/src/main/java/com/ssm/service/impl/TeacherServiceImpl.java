package com.ssm.service.impl;

import com.ssm.dao.TeacherDao;
import com.ssm.entity.Teacher;
import com.ssm.service.ClazzCourseTeacherService;
import com.ssm.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherDao teacherDao;


    @Override
    public List<Teacher> getEmpsByPageHelper(int pageNum, int pageSize) {
        return teacherDao.getTeaByPageHelper(pageNum,pageSize);
    }

    @Override
    public void deleteById(int id) {
        teacherDao.deleteById(id);
    }

    @Override
    public void insert(Teacher teacher) {
        teacherDao.insert(teacher);
    }

    @Override
    public void update(Teacher teacher) {
        teacherDao.update(teacher);
    }

    @Override
    public Teacher getTeacherByNumber(String number) {
        return teacherDao.getTeacherByNumber(number);
    }

    @Override
    public void updatePhoto(Teacher teacher) {
        teacherDao.updatePhoto(teacher);
    }

    @Override
    public void updateByNumber(Teacher teacher) {
        teacherDao.updateByNumber(teacher);
    }

}
