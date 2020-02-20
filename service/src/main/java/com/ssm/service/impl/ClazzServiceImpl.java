package com.ssm.service.impl;

import com.ssm.dao.ClazzDao;
import com.ssm.entity.Clazz;
import com.ssm.service.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClazzServiceImpl implements ClazzService {

    @Autowired
    private ClazzDao dao;
    @Override
    public List<Clazz> getAll(int pageNum,int pageSize) {
        return dao.getAll(pageNum,pageSize);
    }

    @Override
    public List<Clazz> getAllByGradeid(int gradeid) {
        return dao.getAllByGradeid(gradeid);
    }

    @Override
    public Clazz getById(int id) {
        return dao.getById(id);
    }

    @Override
    public void deleteByClazzById(int id) {
        dao.deleteByClazzId(id);
    }

    @Override
    public void insert(Clazz clazz) {
        dao.insert(clazz);
    }

    @Override
    public Clazz getClazzByName(String name) {
        return dao.getClazzByName(name);
    }
}
