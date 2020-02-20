package com.controller;

import com.ssm.entity.Clazz;
import com.ssm.entity.Exam;
import com.ssm.entity.Student;
import com.ssm.service.*;
import config.AppConfig;
import config.MvcConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.jws.soap.SOAPBinding;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class StudentServiceImplTest {
    @Autowired
    private StudentService studentService;

    @Autowired
    private UserService userService;

    @Autowired
    private ClazzService clazzService;
    @Autowired
    private ExamService examService;
    @Autowired
    private GradeService gradeService;
    @Test
    public void getStuByPageHalper() {
        for (Student student : studentService.getStuByPageHalper(1,10)) {
            System.out.println("student = " + studentService.count());
        }
    }

    @Test
    public void getTextThree() {
       userService.deleteById("201301004");
    }

    @Test
    public void getTextFour() {
        System.out.println(" = " + gradeService.getById(1));
    }


}