package com.ssm.controller;

import com.ssm.entity.System;
import com.ssm.entity.User;
import com.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/sys_student")
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/dologin")
    public String login(@RequestParam(value = "account",required = false) String account, @RequestParam(value = "password",required = false) String password, HttpSession session, RedirectAttributes redirectAttribute){
        User user=userService.getByID(account,password);
        if(user!=null){
            loginSucceed(session,userService.getMaxSystem(),user);
            if(user.getType()==1){
                return "/admin/admin";
            }else if(user.getType()==2){
                if("1".equals(session.getServletContext().getAttribute("forbidStudent"))){
                    redirectAttribute.addFlashAttribute("warning","您没有权限登陆");
                  return   "redirect:/sys_student/login";
                }
                return "/student/student";
            }else if(user.getType()==3){
                if("1".equals(session.getServletContext().getAttribute("forbidTeacher"))){
                    redirectAttribute.addFlashAttribute("warning","您没有权限登陆");
                    return "redirect:/sys_student/login";
                }
                return "/teacher/teacher";
            }
            else {
                return "redirect:/sys_student/login";
            }
        }
      loginBedefeated(redirectAttribute,account,password);
        return "redirect:/sys_student/login";
    }
    public static void loginBedefeated(RedirectAttributes redirectAttributes,String account,String password){
        redirectAttributes.addFlashAttribute("warning","登陆失败，请检查账号或者密码！");
        redirectAttributes.addFlashAttribute("account",account);
        redirectAttributes.addFlashAttribute("password",password);
    }
    public static void loginSucceed(HttpSession session, System system,User user){
        session.setAttribute("systemInfo",system);
        session.setAttribute("user",user);
    }


}
