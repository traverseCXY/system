package com.ssm.dao;

import com.ssm.entity.EScore;
import com.ssm.entity.Exam;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EscoreDao {
    void deleteByCourseId(int id);
    int boolExam(EScore eScore);
    void insert(EScore eScore);
    List<EScore> getEScoreByTypeOne(Exam exam);
}
