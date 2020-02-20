package com.ssm.service;

import com.ssm.entity.ExamQuestion;

import java.util.List;

public interface ExamQuestionService {
    List<com.ssm.entity.ExamQuestion> getExamQuestionByExamId(Integer examid);
    void insert(ExamQuestion examQuestion);
}
