package com.ssm.service.impl;

import com.ssm.dao.ExamQuestionDao;
import com.ssm.entity.ExamQuestion;
import com.ssm.service.ExamQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamQuestionServiceImpl implements ExamQuestionService {

    @Autowired
    private ExamQuestionDao examQuestionDao;
    @Override
    public List<ExamQuestion> getExamQuestionByExamId(Integer examid) {
        return examQuestionDao.getExamQuestionByExamId(examid);
    }

    @Override
    public void insert(ExamQuestion examQuestion) {
        examQuestionDao.insert(examQuestion);
    }
}
