package com.ssm.controller;

import com.ssm.entity.Course;
import com.ssm.entity.CourseItem;
import com.ssm.entity.Teacher;
import com.ssm.entity.User;
import com.ssm.service.ClazzCourseTeacherService;
import com.ssm.service.CourseService;
import com.ssm.service.TeacherService;
import com.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.jws.soap.SOAPBinding;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;
    @Autowired
    private UserService userService;
    @Autowired
    private ClazzCourseTeacherService clazzCourseTeacherService;
    @Autowired
    private CourseService courseService;

    @RequestMapping("/toTeacherListView")
    public String toTeacherListView(){
        return "/teacher/teacherList";
    }

    @RequestMapping("/list")
    @ResponseBody
    public List<Teacher> toTeacherList(@RequestParam(value = "pageNum", defaultValue = "1", required = false) int pageNum, @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize) {
        List<Teacher> teacherList=teacherService.getEmpsByPageHelper(pageNum,pageSize);
        for (Teacher teacher : teacherList) {
            List<CourseItem> courseItemList=clazzCourseTeacherService.getClazzCourseTeacherByTeacherId(teacher.getId());
            teacher.setCourseList(courseItemList);
        }
        return teacherList;
    }

    @RequestMapping("/deleteTeacher")
    @ResponseBody
    public String deleteTeahcer(HttpServletRequest req){
        String[] numbers = req.getParameterValues("numbers[]");
        String[]ids= req.getParameterValues("ids[]");
        for (String number : numbers) {
            userService.deleteById(number);
        }
        for(int i =0 ;i < ids.length;i++){
            clazzCourseTeacherService.deleteById(Integer.parseInt(ids[i]));
            teacherService.deleteById(Integer.parseInt(ids[i]));
        }
        return "success";
    }

    @RequestMapping("/addTeacher")
    @ResponseBody
    public String addTeacher(HttpServletRequest request){
        Teacher teacher=getPaream(request);
        teacherService.insert(teacher);
        userService.insert(new User(teacher.getNumber(),teacher.getNumber(),teacher.getName(),3));
        String [] course=request.getParameterValues("course[]");
        insertClazzCourTeacher(course,teacher);
        return "success";
    }

    public void insertClazzCourTeacher(String [] course,Teacher teacher){
        if(course.length>0||course!=null){
            for (String s : course) {
                String[] gcc = s.split("_");
                int gradeid = Integer.parseInt(gcc[0]);
                int clazzid = Integer.parseInt(gcc[1]);
                int courseid = Integer.parseInt(gcc[2]);
                clazzCourseTeacherService.insert(gradeid,clazzid,courseid,teacher.getId());
            }
        }
    }


    public Teacher getPaream(HttpServletRequest request){
        return new Teacher(request.getParameter("number"),request.getParameter("name"),request.getParameter("sex"),request.getParameter("phone"),request.getParameter("qq"));
    }
    @RequestMapping("/editTeacher")
    @ResponseBody
    public String editTeacher(HttpServletRequest request){
       Teacher teacher= new Teacher(Integer.parseInt(request.getParameter("id")),request.getParameter("number"),request.getParameter("name"),request.getParameter("sex"),request.getParameter("phone"),request.getParameter("qq"));
        teacherService.update(teacher);
        userService.updateUserByaccount(new User(teacher.getName(),teacher.getNumber()));
        clazzCourseTeacherService.deleteByTeacher(teacher.getId());
        String [] course=request.getParameterValues("course[]");
        insertClazzCourTeacher(course,teacher);
        return "success";
    }

    @RequestMapping("/toExamTeacherView")
    public String examTeacherList(){
        return  "/teacher/examTeacherList";
    }
    @RequestMapping("/toTeacherNoteListView")
    public String toTeacherNoteListView(){
        return  "/teacher/teacherNoteList";
    }
    @RequestMapping("/toTeacherPersonalView")
    public String toTeacherPersonalView(HttpSession session){
        Teacher teacher=teacherService.getTeacherByNumber(((User)session.getAttribute("user")).getAccount());
        session.setAttribute("userDetail",teacher);
        return  "/teacher/teacherPersonal";
    }

    @RequestMapping("/getTeacher")
    @ResponseBody
    public  Teacher getTeacher(HttpSession session){
        User user= (User) session.getAttribute("user");
        Teacher teacher=teacherService.getTeacherByNumber(user.getAccount());
        teacher.setCourseList(clazzCourseTeacherService.getClazzCourseTeacherByTeacherId(teacher.getId()));
        System.out.println("teacher = " + teacher);
        return teacher;
    }

    @RequestMapping("/editPasswod")
    @ResponseBody
    public String editPasswod(String password,HttpSession session){
        User user= (User) session.getAttribute("user");
        user.setPassword(password);
        userService.updateUser(user);
        return "success";
    }

    @RequestMapping("/editTeacherPersonal")
    @ResponseBody
    public String editTeacherPersonal(Teacher teacher){
        teacherService.update(teacher);
        return "success";
    }


    @RequestMapping("/editTeacherPhoto")
    public String editTeacherPhoto(MultipartFile pimage,HttpSession session) throws IOException {
        User user=(User)session.getAttribute("user");
        String path="D:/workspace/sys-student/controller/src/main/resources/static/image";
        //取得上传文件名
        String filename=pimage.getOriginalFilename();
        String filepath=path+ File.separator+filename;
        File file=new File(filepath);
        //上传文件
        pimage.transferTo(file);
        Teacher teacher=new Teacher();
        teacher.setPhoto("/static/image"+File.separator+filename);
        teacher.setNumber(user.getAccount());
        teacherService.updatePhoto(teacher);
        return "redirect:/toTeacherPersonalView";
    }






}
