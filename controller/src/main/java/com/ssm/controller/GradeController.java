package com.ssm.controller;

import com.ssm.entity.Grade;
import com.ssm.entity.GradeCourse;
import com.ssm.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/grade")
public class GradeController {

    @Autowired
    private GradeService gradeService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private ClazzService clazzService;

    @Autowired
    private GradeCourseService gradeCourseService;

    @Autowired
    private CourseService courseService;

    @PostMapping("/list")
    @ResponseBody
    public List<Grade> getAll(String course) {
        List<Grade> gradeList = gradeService.getAll();
        if("course".equals(course)){
            for (Grade grade : gradeList) {
                grade.setCourseList(courseService.getCourseByGradeId(grade.getId()));
            }
        }
        return gradeList;
    }

    @RequestMapping("/toGradeListView")
    public String toGradeListView(){
        return "/other/gradeList";
    }

    @RequestMapping("/deleteByGradeId")
    @ResponseBody
    public String deleteByGradeId(int gradeid){
        studentService.deleteByGradeId(gradeid);
        clazzService.deleteByClazzById(gradeid);
        gradeService.deleteByGradeId(gradeid);
        return "success";
    }

    @RequestMapping("/addGrade")
    @ResponseBody
    public String addGrade(String name,Integer [] clazzid, HttpServletRequest req){
        Grade grade=new Grade();
        grade.setName(name);
        gradeService.insert(grade);
        for (int clazzid1 : clazzid) {
            System.out.println("clazzid = " + clazzid1+name);
            gradeCourseService.insert(new GradeCourse(grade.getId(),clazzid1));
        }
        return "success";
    }
}
