package com.ssm.service.impl;

import com.ssm.dao.EscoreDao;
import com.ssm.entity.EScore;
import com.ssm.entity.Exam;
import com.ssm.service.EscoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EscoreServiceImpl implements EscoreService {

    @Autowired
    private EscoreDao escoreDao;

    @Override
    public void deleteByCourseId(int id) {
        escoreDao.deleteByCourseId(id);
    }

    @Override
    public Integer boolExam(EScore eScore) {
        return escoreDao.boolExam(eScore);
    }

    @Override
    public void inesrt(EScore eScore) {
        escoreDao.insert(eScore);
    }

    @Override
    public List<EScore> getEScoreByTypeOne(Exam exam) {
        return escoreDao.getEScoreByTypeOne(exam);
    }

}
