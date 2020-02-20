package com.ssm.controller;

import com.ssm.entity.Course;
import com.ssm.entity.EScore;
import com.ssm.entity.Exam;
import com.ssm.entity.Student;
import com.ssm.service.CourseService;
import com.ssm.service.EscoreService;
import com.ssm.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/score")
public class ScoreController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private EscoreService escoreService;

    @Autowired
    private StudentService studentService;

    @RequestMapping("/columnList")
    @ResponseBody
    public List<Course> columnList(Exam exam){
        System.out.println("exam = " + exam);
        List<Course> list=null;
        if(exam.getType() == Exam.EXAM_GRADE_TYPE){ //年级考试
            //获取考试的科目
            list =courseService.getCourseByGradeId(exam.getGradeid());
        } else{
            //获取某科
            list =  courseService.getCourseById(exam.getCourseid());
        }
        for (Course course : list) {
            System.out.println("soutv = " + course);
        }
        return list;
    }

    @RequestMapping("/scoreList")
    @ResponseBody
    public List<EScore> scoreList(Exam exam){
        System.out.println("exam = " + exam);
        List<EScore> list=escoreService.getEScoreByTypeOne(exam);
        for (EScore eScore : list) {
            eScore.setStudent(studentService.getStudentByExamId(eScore.getStudentid()));
        }
        return list;
    }
}
