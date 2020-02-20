package com.ssm.service;

import com.ssm.entity.EScore;
import com.ssm.entity.Exam;
import java.util.List;

public interface EscoreService {

    void deleteByCourseId(int id);

    Integer boolExam(EScore eScore);

    void inesrt(EScore eScore);

    List<EScore> getEScoreByTypeOne(Exam exam);
}
