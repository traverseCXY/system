package com.ssm.dao;

import com.ssm.entity.ExamQuestion;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExamQuestionDao {

    List<ExamQuestion> getExamQuestionByExamId(Integer examid);

    void insert(ExamQuestion examQuestion);

}
