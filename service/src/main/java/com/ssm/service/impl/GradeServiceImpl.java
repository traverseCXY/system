package com.ssm.service.impl;

import com.ssm.dao.GradeDao;
import com.ssm.entity.Grade;
import com.ssm.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GradeServiceImpl implements GradeService {

    @Autowired
    private GradeDao gradeDao;

    @Override
    public List<Grade> getAllGrade(Integer pageNum, Integer pageSizse) {
        return gradeDao.getAllGrade(pageNum,pageSizse);
    }

    @Override
    public List<Grade> getAll() {
        return gradeDao.getAll();
    }

    @Override
    public Grade getById(Integer id) {
        return gradeDao.getById(id);
    }

    @Override
    public void update(Grade grade) {
        gradeDao.update(grade);
    }

    @Override
    public int insert(Grade grade) {
        return gradeDao.insert(grade);
    }

    @Override
    public Grade getGradeByName(String name) {
        return gradeDao.getGradeByName(name);
    }


    @Override
    public void deleteByGradeId(Integer id) {
        gradeDao.deleteByGradeId(id);
    }
}
