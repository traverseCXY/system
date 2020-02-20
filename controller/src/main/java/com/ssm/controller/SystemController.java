package com.ssm.controller;

import com.ssm.entity.User;
import com.ssm.service.SystemService;
import com.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class SystemController {

    @Autowired
    private UserService userService;

    @Autowired
    private SystemService systemService;

    @RequestMapping("/toAdminPersonalView")
    public String toAdminPersonalView(){
        return "/admin/adminPersonal";
    }

    @RequestMapping("/EditSystemInfo")
    @ResponseBody
    public String EditSystemInfo(String name, String value, HttpSession req){
        if("forbidStudent".equals(name)){
            if("1".equals(value)){
                req.getServletContext().setAttribute("forbidStudent","1");
            }else{
                req.getServletContext().setAttribute("forbidStudent","0");
            }
        } else if("forbidTeacher".equals(name)){
            if("1".equals(value)){
                req.getServletContext().setAttribute("forbidTeacher","1");
            }else{
                req.getServletContext().setAttribute("forbidTeacher","0");
            }
        }else if("schoolName".equals(name)){
            systemService.update(name, value);
        }
        return "success";
    }

    @RequestMapping("/editPasswod")
    @ResponseBody
    public String editPasswod(User user){
        userService.updateUser(user);
        return "success";
    }
}
