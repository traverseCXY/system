package com.controller;

import com.ssm.entity.CourseItem;
import com.ssm.service.ClazzCourseTeacherService;
import config.AppConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class clazzCourseTeacherServiceTest {

    @Autowired
    private ClazzCourseTeacherService clazzCourseTeacherService;
    @Test
    public void getClazzCourseTeacherService(){
       List< CourseItem >courseItem=clazzCourseTeacherService.getClazzCourseTeacherByTeacherId(1);
        for (CourseItem item : courseItem) {
            System.out.println("item = " + item);
        }

    }
}
