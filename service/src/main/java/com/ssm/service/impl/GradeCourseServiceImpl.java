package com.ssm.service.impl;

import com.ssm.dao.GradeCourseDao;
import com.ssm.entity.GradeCourse;
import com.ssm.service.GradeCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GradeCourseServiceImpl implements GradeCourseService {
    @Autowired
    private GradeCourseDao gradeCourseDao;

    @Override
    public void insert(GradeCourse gradeCourse) {
        gradeCourseDao.insert(gradeCourse);
    }

    @Override
    public void deleteByCourseId(int id) {
        gradeCourseDao.deleteByCourseId(id);
    }
}
