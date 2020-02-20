package com.ssm.controller;

import com.ssm.entity.Course;
import com.ssm.service.ClazzCourseTeacherService;
import com.ssm.service.CourseService;
import com.ssm.service.EscoreService;
import com.ssm.service.GradeCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @Autowired
    private EscoreService escoreService;

    @Autowired
    private ClazzCourseTeacherService clazzCourseTeacherService;

    @Autowired
    private GradeCourseService gradeCourseService;

    @RequestMapping("/list")
    @ResponseBody
    public List<Course> getAll(@RequestParam(value = "gradeid",defaultValue = "0",required = false)int gradeid){
        if(gradeid==0){
            return courseService.getAll();
        }
        return courseService.getCourseById(gradeid);
    }

    @RequestMapping("/toCourseListView")
    public String toCourseListView(){
        return "/other/courseList";
    }

    @RequestMapping("/deleteCourse")
    @ResponseBody
    public String deleteCourse(int courseid){
        escoreService.deleteByCourseId(courseid);
        courseService.deleteById(courseid);
        clazzCourseTeacherService.deleteByCourseId(courseid);
        gradeCourseService.deleteByCourseId(courseid);
        return "success";
    }

    @RequestMapping("/addCourse")
    @ResponseBody
    public String addCourse(Course course){
        courseService.insert(course);
        return "success";
    }

}
