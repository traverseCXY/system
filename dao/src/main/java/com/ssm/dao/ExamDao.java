package com.ssm.dao;

import com.ssm.entity.CourseItem;
import com.ssm.entity.Exam;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ExamDao {
    List<Exam> getAllExam(@Param("pageNum") int pageNum, @Param("pageSize") int pageSize);
    List<Exam> getAll();
    Exam getById(Integer id);
    void byIdDelete(Integer id);
    void addExam(Exam exam);
    List<Exam> getExamByTeacherId(CourseItem courseItem);
    List<Exam>getExamByStudent(int gradeid,int clazzid);
}

