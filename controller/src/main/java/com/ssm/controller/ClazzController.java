package com.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.ssm.entity.Clazz;
import com.ssm.entity.Grade;
import com.ssm.service.ClazzService;
import com.ssm.service.GradeService;
import com.ssm.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/clazz")
public class ClazzController {

    @Autowired
    private ClazzService clazzService;

    @Autowired
    private GradeService gradeService;

    @Autowired
    private StudentService studentService;

    @PostMapping("/list")
    @ResponseBody
    public List<Clazz> getAll(@RequestParam(value = "gradeid",defaultValue = "0",required = false) int gradeid,@RequestParam(value = "pageNum",required = false,defaultValue = "1") int pageNum,
                              @RequestParam(value = "pageSize",required = false,defaultValue = "10")int pageSize,
                              Model model){
        List<Clazz> results=null;
        if(gradeid==0){
            results= clazzService.getAll(pageNum,pageSize);
        }else{
            results=clazzService.getAllByGradeid(gradeid);
        }
        for (Clazz result : results) {
            Grade grade=gradeService.getById(result.getGradeid());
            result.setGrade(grade);
        }
        PageInfo pageInfo=new PageInfo(results,3);
        model.addAttribute("pageInfo",pageInfo);
        return results;
    }

    @RequestMapping("/toClazzListView")
    public String toClazzListView(){
        return "/other/clazzList";
    }

    @RequestMapping("/deleteClazz")
    @ResponseBody
    public String delete(int clazzid){
        studentService.deleteByClazzId(clazzid);
        clazzService.deleteByClazzById(clazzid);
        return "success";
    }

    @RequestMapping("/addClazz")
    @ResponseBody
    public String addClazz(Clazz clazz){
        clazzService.insert(clazz);
        return "success";
    }
}
