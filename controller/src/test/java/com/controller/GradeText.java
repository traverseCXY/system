package com.controller;

import com.ssm.entity.Grade;
import com.ssm.service.GradeService;
import config.AppConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes =AppConfig.class)
public class GradeText {

    @Autowired
    private GradeService gradeService;

    @Test
    public void addGradeServiceText(){
        Grade grade=new Grade();
        grade.setName("123");
        gradeService.insert(grade);
        System.out.println(" = " + grade.getId());
    }
    @Test
    public void getGradeByName(){
        System.out.println("gradeService = " + gradeService.getGradeByName("2015"));
    }
}
