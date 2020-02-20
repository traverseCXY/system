package com.controller;

import com.ssm.entity.Teacher;
import com.ssm.service.TeacherService;
import config.AppConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class teacherServiceImplTest {
    
    @Autowired
    private TeacherService teacherServicel;
    
    @Test
    public void getAllList() {
        List<Teacher> list = teacherServicel.getEmpsByPageHelper(1, 2);
        for (Teacher teacher : list) {
            System.out.println("teacher = " + teacher);
        }
    }
    
}
