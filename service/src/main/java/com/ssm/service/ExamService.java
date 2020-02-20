package com.ssm.service;

import com.ssm.entity.CourseItem;
import com.ssm.entity.Exam;

import java.util.List;

public interface ExamService {
    List<Exam>getAllExam(int pageNum,int pageSize);
    List<Exam> getAll();
    Exam getById(Integer id);
    void byIdDelete(Integer id);
    void addExam(Exam exam);
    List<Exam> getExamByTeacherId(CourseItem courseItem);
    List<Exam>getExamByStudent(int gradeid,int clazzid);
}
