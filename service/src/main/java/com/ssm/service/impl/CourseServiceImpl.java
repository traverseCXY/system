package com.ssm.service.impl;

import com.ssm.dao.CourseDao;
import com.ssm.entity.Course;
import com.ssm.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseDao courseDao;
    @Override
    public Course getById(Integer id) {
        return courseDao.getById(id);
    }

    @Override
    public List<Course> getAll() {
        return courseDao.getAll();
    }

    @Override
    public List<Course> getCourseById(int id) {
        return courseDao.getCourseById(id);
    }

    @Override
    public List<Course> getCourseByTeacherId(int id) {
        return courseDao.getCourseByTeacherId(id);
    }

    @Override
    public void deleteById(int id) {
        courseDao.deleteById(id);
    }

    @Override
    public List<Course> getCourseByGradeId(int id) {
        return courseDao.getCourseByGradeId(id);
    }

    @Override
    public void insert(Course course) {
        courseDao.insert(course);
    }


}
