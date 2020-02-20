package com.ssm.service;

import com.ssm.entity.GradeCourse;

public interface GradeCourseService {
    void insert(GradeCourse gradeCourse);
    void deleteByCourseId(int id);
}
