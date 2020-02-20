package com.ssm.controller;

import com.ssm.entity.*;
import com.ssm.service.ClazzService;
import com.ssm.service.ExamQuestionService;
import com.ssm.service.GradeService;
import com.ssm.service.StudentService;
import jxl.Sheet;
import jxl.Workbook;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.hwpf.usermodel.Range;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.lang.System;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/file")
public class FileController {

    @Autowired
    private ExamQuestionService examQuestionService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private ClazzService clazzService;

    @Autowired
    private GradeService gradeService;

    private static HttpSession session;

    @RequestMapping("/test")
    public String test(){
        return "test";
    }

    @RequestMapping("/studentUpload")
   @ ResponseBody
    public String toStudentFile(MultipartFile multipartFile, HttpSession session) throws IOException {
        String path="D:/workspace/sys-student/controller/src/main/resources/static/image";
        //取得上传文件名
        String filename=multipartFile.getOriginalFilename();
        String filepath=path+ File.separator+filename;
        File file=new File(filepath);
        //上传文件
        multipartFile.transferTo(file);
        System.out.println("filepath = " + filepath);
        session.setAttribute("imgpath","/static/image/"+filepath);
        return "ok";
    }

    @RequestMapping("/importExcel")
    @ResponseBody
    public Integer importExcel(@RequestParam("file") MultipartFile file) {
        int n = 0;
        //成功录入提数记录
        List<String[]> userList = new ArrayList<String[]>();
        try {
            // 1:创建workbook
            Workbook workbook = Workbook.getWorkbook(file.getInputStream());
            // 2:获取第一个工作表sheet
            Sheet sheet = workbook.getSheet(0);
            // 3:获取数据			//System.out.println("行：" + sheet.getRows());			//System.out.println("列：" + sheet.getColumns());
            int rsColumns = sheet.getColumns();
            // 读取文件中数据
            for (int i = 1; i < sheet.getRows(); i++) {
                String[] rowValue = new String[rsColumns];
                for (int j = 0; j < rsColumns; j++) {
                    if ("".equals(sheet.getCell(j, i).getContents()) || sheet.getCell(j, i).getContents() == null) {
                        rowValue[j] = "";
                    } else {
                        rowValue[j] = sheet.getCell(j, i).getContents();
                    }
                }
                userList.add(rowValue);
            }
            // 最后一步：关闭资源
            workbook.close();
            // 判断EXCEL文件中没有数据
            if (userList.size() > 0) {
                // 选择文件不为空
                for (int i = 0; i < userList.size(); i++) {
                    String[] userArrayOne = null;
                    userArrayOne = userList.get(i);
                    String type = userArrayOne[0];// 题目类别
                    String qtype = userArrayOne[1];// 题目类型
                    String title = userArrayOne[2];// 题干
                    String option1 = userArrayOne[3];// 选项内容1
                    String option2 = userArrayOne[4];// 选项内容2
                    String option3 = userArrayOne[5];// 选项内容3
                    String option4 = userArrayOne[6];// 选项内容4
                    String trueOption = userArrayOne[7];// 正确选项
                    ExamQuestion examQuestion=new ExamQuestion();
                    examQuestion.setQuesttions(userArrayOne[3]);
                    examQuestion.setOptionA(userArrayOne[4]);
                    examQuestion.setOptionB(userArrayOne[5]);
                    examQuestion.setOptionC(userArrayOne[6]);
                    examQuestion.setOptionD(userArrayOne[7]);
                    examQuestion.setAnswer(userArrayOne[8]);
                    examQuestion.setType(Integer.parseInt(userArrayOne[2]));
                    examQuestionService.insert(examQuestion);
                    //examQuestionList.add(examQuestion);
                }
            }else{
                //如果导入表格为空返回-1
                return -1;
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
        return userList.size();
    }

    @RequestMapping("/importWordTest")
    public  String importWordTest(){
        return "importWordTest";
    }

    @RequestMapping("/importWord")
    @ResponseBody
    public Integer importWord(MultipartFile file) throws IOException {
        String filename=file.getOriginalFilename();
        String buffer="";
        String [] filenames=filename.split("\\.");
       if("doc".equals(filenames[filenames.length-1])){
           WordExtractor ex = new WordExtractor(file.getInputStream());
           buffer=ex.getText();
           ex.close();
       }else{
           return -1;
       }
        String [] buffers=buffer.trim().split("\r\n");
        for (String s : buffers) {
            String [] tgs=s.split("\\?");
            ExamQuestion examQuestion=new ExamQuestion();
            examQuestion.setQuesttions(tgs[0]);
            String [] questiones=tgs[tgs.length-1].split(",");
            examQuestion.setOptionA(questiones[0]);
            examQuestion.setOptionB(questiones[1]);
            examQuestion.setOptionC(questiones[2]);
            examQuestion.setOptionD(questiones[3]);
            examQuestion.setAnswer(questiones[4]);
            examQuestion.setType(Integer.parseInt(questiones[5]));
            examQuestion.setValue(Integer.parseInt(questiones[6]));
            System.out.println("examQuestion = " + examQuestion);
        }
       return 1;
    }

    @RequestMapping("/batchAdd")
    @ResponseBody
    public Integer batchAdd(@RequestParam("file")MultipartFile file){
        int n = 0;
        //成功录入提数记录
        List<String[]> userList = new ArrayList<String[]>();
        try {
            // 1:创建workbook
            Workbook workbook = Workbook.getWorkbook(file.getInputStream());
            // 2:获取第一个工作表sheet
            Sheet sheet = workbook.getSheet(0);
            // 3:获取数据			//System.out.println("行：" + sheet.getRows());			//System.out.println("列：" + sheet.getColumns());
            int rsColumns = sheet.getColumns();
            // 读取文件中数据
            for (int i = 1; i < sheet.getRows(); i++) {
                String[] rowValue = new String[rsColumns];
                for (int j = 0; j < rsColumns; j++) {
                    if ("".equals(sheet.getCell(j, i).getContents()) || sheet.getCell(j, i).getContents() == null) {
                        rowValue[j] = "";
                    } else {
                        rowValue[j] = sheet.getCell(j, i).getContents();
                    }
                }
                userList.add(rowValue);
            }
            // 最后一步：关闭资源
            workbook.close();
            // 判断EXCEL文件中没有数据
            if (userList.size() > 0) {
                // 选择文件不为空
                for (int i = 0; i < userList.size(); i++) {
                    String[] userArrayOne = null;
                    userArrayOne = userList.get(i);
                    StudentVO student=new StudentVO();
                    student.setNumber(userArrayOne[0]);
                    student.setName(userArrayOne[1]);
                    student.setSex(userArrayOne[2]);
                    student.setPhone(userArrayOne[3]);
                    student.setQq(userArrayOne[4]);
                    student.setClazzid(clazzService.getClazzByName(userArrayOne[5]).getId());
                    student.setGradeid(gradeService.getGradeByName(userArrayOne[6]).getId());
                    if(userArrayOne[7]!=null||userArrayOne[7]!=""){
                        student.setImgpath(userArrayOne[7]);
                    }
                    System.out.println("student = " + student);
                    studentService.insert(student);
                }
            }else{
                //如果导入表格为空返回-1
                return -1;
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
        return userList.size();
    }


}
