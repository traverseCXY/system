package com.ssm.service.impl;

import com.ssm.dao.ExamDao;
import com.ssm.entity.CourseItem;
import com.ssm.entity.Exam;
import com.ssm.service.ClazzCourseTeacherService;
import com.ssm.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamServiceImpl implements ExamService {

    @Autowired
    private ExamDao examDao;

    @Autowired
    private ClazzCourseTeacherService clazzCourseTeacherService;

    @Override
    public List<Exam> getAllExam(int pageNum, int pageSize) {
        return examDao.getAllExam(pageNum, pageSize);
    }

    @Override
    public List<Exam> getAll() {
        System.out.println("\"----\" = " + "----");
        return examDao.getAll();
    }

    @Override
    public Exam getById(Integer id) {
        return examDao.getById(id);
    }

    @Override
    public void byIdDelete(Integer id) {
         examDao.byIdDelete(id);
    }

    @Override
    public void addExam(Exam exam) {
        examDao.addExam(exam);
    }

    @Override
    public List<Exam> getExamByTeacherId(CourseItem courseItem) {
        return examDao.getExamByTeacherId(courseItem);
    }

    @Override
    public List<Exam> getExamByStudent(int gradeid, int clazzid) {
        return examDao.getExamByStudent(gradeid,clazzid);
    }

}
