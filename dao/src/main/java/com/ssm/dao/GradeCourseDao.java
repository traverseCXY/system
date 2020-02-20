package com.ssm.dao;

import com.ssm.entity.Grade;
import com.ssm.entity.GradeCourse;
import org.springframework.stereotype.Repository;

@Repository
public interface GradeCourseDao {
    void  insert(GradeCourse gradeCourse);
    void deleteByCourseId(int id);
}
