package com.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.ssm.entity.*;
import com.ssm.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.lang.System;
import java.util.List;

@Controller
@RequestMapping("/exam")
public class ExamController {

    @Autowired
    private ExamService examService;

    @Autowired
    private ClazzService clazzService;

    @Autowired
    private GradeService gradeService;

    @Autowired
    private CourseService courseService;

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private ClazzCourseTeacherService clazzCourseTeacherService;

    @Autowired
    private StudentService studentService;

    @RequestMapping("/examview")
    public String toExamView(){
        return "/other/examList";
    }

    @RequestMapping("/examlist")
    @ResponseBody
    public List<Exam> toExamList(@RequestParam(value = "pageNum",defaultValue = "1",required = false)int pageNum,@RequestParam(value = "pageSize",defaultValue = "10",required = false)int pageSize){
        List<Exam> examList=examService.getAllExam(pageNum,pageSize);
        for (Exam exam : examList) {
            if(exam.getGradeid()!=0){
                exam.setGrade(gradeService.getById(exam.getGradeid()));
            }
            if(exam.getClazzid()!=0){
                exam.setClazz(clazzService.getById(exam.getId()));
            }
            exam.setCourse(courseService.getById(exam.getCourseid()));
        }
      //  PageInfo pageInfo=new PageInfo(examList,10);
        return examList;
    }

    @RequestMapping("/ByIdDelete")
    @ResponseBody
    public String byIdDelete(Integer id){
        examService.byIdDelete(id);
        return "success";
    }

    @RequestMapping("/addExam")
    @ResponseBody
    public String addExam(Exam exam){
        examService.addExam(exam);
        return "success";
    }

    @RequestMapping("/teacherExamList")
    @ResponseBody
    public List<Exam> teacherExamList(HttpSession session){
        User user= (User) session.getAttribute("user");
        Teacher teacher=teacherService.getTeacherByNumber(user.getAccount());
        CourseItem courseItem=clazzCourseTeacherService.getClazzIdByTeacherId(teacher.getId());
        List<Exam> examList=examService.getExamByTeacherId(courseItem);
        for (Exam exam : examList) {
            exam.setGrade(gradeService.getById(exam.getGradeid()));
            exam.setClazz(clazzService.getById(exam.getClazzid()));
            exam.setCourse(courseService.getById(exam.getCourseid()));
        }
        return examList;
    }

    @RequestMapping("/studentExamList")
    @ResponseBody
    public List<Exam> studentExamList(HttpSession session){
        Student student=studentService.getStudentByNumber(((User)session.getAttribute("user")).getAccount());
        List<Exam> examList=examService.getExamByStudent(student.getGradeid(),student.getClazzid());
        for (Exam exam : examList) {
            System.out.println("exam = " + exam);
            exam.setGrade(gradeService.getById(exam.getGradeid()));
            exam.setClazz(clazzService.getById(exam.getClazzid()));
            exam.setCourse(courseService.getById(exam.getCourseid()));
        }
        return examList;
    }
}
