package com.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.ssm.entity.*;
import com.ssm.service.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import java.io.File;
import java.io.IOException;
import java.lang.System;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
    private static final Integer PAGESIZE=10;
    @Autowired
    private StudentService studentService;
    @Autowired
    private ClazzService clazzService;
    @Autowired
    private GradeService gradeService;
    @Autowired
    private EscoreService escoreService;

    @Autowired
    private UserService userService;

    @Autowired
    private TeacherService teacherService;

     @PostMapping("/list")
     @ResponseBody
    public List<Student> stuIndex(@RequestParam(value = "page",defaultValue = "1",required = false) Integer page, @RequestParam(value = "rows",defaultValue = "10",required = false) Integer rows, @RequestParam(value = "clazzid",defaultValue = "0",required = false) Integer clazzid, Model model){
         if(clazzid==0){
             List<Student> results = studentService.getStuByPageHalper(page,studentService.count());
            return (List<Student>) listForeach(results);
         }
         List<Student> result=studentService.getStuByClazzid(clazzid);
         List<Student> studentList=(List<Student>) listForeach(result);
         return studentList;
     }

     private List<?> listForeach(List<Student> list){
         List<Student> results=list;
         for (Student result : results) {
             Clazz clazz= clazzService.getById(result.getClazzid());
             Grade grade=gradeService.getById(result.getGradeid());
             result.setGrade(grade);
             result.setClazz(clazz);
         }
         return results;
     }

     @RequestMapping("/insert")
     @ResponseBody
    public String stuInsert( StudentVO studentVO) throws IOException {
        String path="D:/workspace/sys-student/controller/src/main/resources/static/image";
         //取得上传文件名
         String filename=studentVO.getMultipartFile().getOriginalFilename();
         String filepath=path+ File.separator+filename;
         File file=new File(filepath);
         //上传文件
         studentVO.getMultipartFile().transferTo(file);
         studentVO.setImgpath("/static/image"+File.separator+filename);
         studentService.insert(studentVO);
         userService.insert(new User(studentVO.getNumber(),studentVO.getNumber(),studentVO.getName()));
         return "success";
     }

     @RequestMapping("/delete")
     @ResponseBody
    public String stuDelete(HttpServletRequest req){
         String[] numbers = req.getParameterValues("numbers[]");
         String[]ids= req.getParameterValues("ids[]");
         for (String number : numbers) {
            userService.deleteById(number);
         }
         for(int i =0 ;i < ids.length;i++){
             studentService.delete(Integer.parseInt(ids[i]));
         }
         return "success";
     }

    @RequestMapping("/studentview")
    public String toStudentView(){
         return "/student/studentList";
    }
    

    @RequestMapping("/editStudentPhoto")
    @ResponseBody
    public String byId(String number){
        System.out.println(" studentService.getById(number).getImgpath() = " +  studentService.getById(number).getImgpath());
         return studentService.getById(number).getImgpath();
    }

    @RequestMapping("/toExamStudentView")
    public String toExamStudentView(){
         return "/student/examStudentList";
    }

    @RequestMapping("/toStudentNoteListView")
    public String toStudentNoteListView(){
         return "/student/studentNoteList";
    }

    @RequestMapping("/toStudentPersonalView")
    public String toStudentPersonalView(HttpSession session){
        Student student=studentService.getStudentByNumber(((User)session.getAttribute("user")).getAccount());
        System.out.println("student = " + student);
        session.setAttribute("userDetail",student);
        return "/student/studentPersonal";
    }
    @RequestMapping("/toStudentInformation")
    public String toStudentInformation(){
        return "/summitexam/index";
    }

    @RequestMapping("/studentClazzList")
    @ResponseBody
    public List<Student> studentClazzList(@RequestParam(value = "page",defaultValue = "1",required = false) Integer page, @RequestParam(value = "rows",defaultValue = "10",required = false) Integer rows,HttpSession session){
         User user=(User)session.getAttribute("user");
         Student student=studentService.getStudentByNumber(user.getAccount());
         List<Student> studentList=studentService.getStuByStuClazzid(page, rows, student.getClazzid());
        for (Student student1 : studentList) {
            student1.setClazz(clazzService.getById(student1.getClazzid()));
            student1.setGrade(gradeService.getById(student1.getGradeid()));
        }
         return studentList;
    }

    @RequestMapping("/editPasswod")
    @ResponseBody
    public String editPasswod(String password, HttpSession session){
         User user=(User)session.getAttribute("user");
         user.setPassword(password);
        System.out.println("user = " + user);
        userService.updateUser(user);
        return "success";
    }

    public static String setPhoto(MultipartFile pimage) throws IOException {
        String path="D:\\workspace\\sys-student\\controller\\src\\main\\resources\\static\\image";
        //取得上传文件名
        String filename=pimage.getOriginalFilename();
        String filepath=path+ File.separator+filename;
        File file=new File(filepath);
        //上传文件
        pimage.transferTo(file);
        return "\\static\\image"+File.separator+filename;
    }

    @RequestMapping("/editStudent")
    @ResponseBody
    public String editStudent(StudentVO student) throws IOException {
         if(student.getMultipartFile()!=null){
            student.setImgpath(setPhoto(student.getMultipartFile()));
         }
         studentService.update(student);
         return "success";
    }

    //判断该学生是否参加考试
    @RequestMapping("/boolExam")
    @ResponseBody
    public BoolExam boolExam(Exam exam,HttpSession session){
        User user=(User)session.getAttribute("user");
        Student student=studentService.getStudentByNumber(user.getAccount());
        EScore eScore=new EScore(exam.getId(),exam.getClazzid(),student.getId(),exam.getGradeid(),exam.getCourseid());
       Integer result=escoreService.boolExam(eScore);
       BoolExam boolExam=new BoolExam(exam.getId());
        if(result>0) {
            boolExam.setaBoolean("false");
        }else{
            boolExam.setaBoolean("true");
        }
        return boolExam;
    }
}
