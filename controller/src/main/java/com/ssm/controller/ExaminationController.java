package com.ssm.controller;

import com.ssm.entity.*;
import com.ssm.service.*;
import com.sun.net.httpserver.HttpServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.System;
import java.util.List;

@Controller
@RequestMapping("/examination")
public class ExaminationController {

    @Autowired
    private ExamQuestionService examQuestionService;

    @Autowired
    private ResultService resultService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private EscoreService escoreService;

    @Autowired
    private CourseService courseService;

    private  Integer examid;

    @RequestMapping("/index")
    public String  examinatinoIndex(Integer examid, HttpSession session){
        List<ExamQuestion> examQuestionList=examQuestionService.getExamQuestionByExamId(examid);
        session.setAttribute("list",examQuestionList);
        this.examid=examid;
        return "/summitexam/index";
    }

    @RequestMapping("/getSubmitExamQuestion")
    public String getSubmitExamQuestion(HttpServletRequest request,HttpSession session){
        Student student=studentService.getStudentByNumber(((User)session.getAttribute("user")).getAccount());
        List<ExamQuestion> examQuestionList=(List<ExamQuestion>) request.getSession().getAttribute("list");
        int fenshu=0;
        for(ExamQuestion exam:examQuestionList){
            if (exam.getType()==2){
                String[] answers=request.getParameterValues(""+exam.getId());
                String answer = "";
                for (String an : answers) {
                    answer+=an;
                }
                System.out.println("answer = " + answer);
              if(exam.getAnswer().equalsIgnoreCase(answer)){
                    fenshu+=exam.getValue();
                    resultService.insert(new Result(student.getId(),exam.getId(),"true"));
                }else{
                    resultService.insert(new Result(student.getId(),exam.getId(),"false"));
                }
            }
            else if(exam.getAnswer().equalsIgnoreCase(request.getParameter(""+exam.getId()))){
                fenshu+=exam.getValue();
                resultService.insert(new Result(student.getId(),exam.getId(),"true"));
            }else{
                resultService.insert(new Result(student.getId(),exam.getId(),"false"));
            }
        }
        System.out.println("分数："+fenshu);
        EScore eScore = new EScore(examQuestionList.get(0).getExamid(),student.getClazzid(),student.getId(),student.getGradeid(),examid);
        escoreService.inesrt(eScore);
        return "redirect:/student/toExamStudentView";
    }
}
