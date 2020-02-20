package com.ssm.service;

import com.ssm.entity.Grade;
import java.util.List;

public interface GradeService {

    void deleteByGradeId(Integer id);

    List<Grade> getAllGrade(Integer pageNum,Integer pageSizse);

    List<Grade> getAll();

    Grade getById(Integer id);

    void update(Grade grade);

    int insert(Grade grade);

    Grade getGradeByName(String name);
}
