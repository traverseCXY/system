package com.ssm.service.impl;

import com.ssm.dao.ClazzCourseTeacherDao;
import com.ssm.entity.CourseItem;
import com.ssm.service.ClazzCourseTeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClazzCourseTeacherServiceImpl implements ClazzCourseTeacherService {
    @Autowired
    private ClazzCourseTeacherDao clazzCourseTeacherDao;
    @Override
    public void deleteById(int id) {
        clazzCourseTeacherDao.deleteById(id);
    }

    @Override
    public void deleteByCourseId(int id) {
        clazzCourseTeacherDao.deleteByCourseId(id);
    }

    @Override
    public List<CourseItem> getClazzCourseTeacherByTeacherId(int id) {
        return clazzCourseTeacherDao.getClazzCourseTeacherByTeacherId(id);
    }

    @Override
    public void insert(int gradeid, int clazzid, int courseid, int teacherid) {
        clazzCourseTeacherDao.insert(gradeid, clazzid, courseid, teacherid);
    }

    @Override
    public void deleteByTeacher(int id) {
        clazzCourseTeacherDao.deleteByTeacherId(id);
    }

    @Override
    public CourseItem getClazzIdByTeacherId(int id) {
        return clazzCourseTeacherDao.getClazzIdByTeacherId(id);
    }
}
