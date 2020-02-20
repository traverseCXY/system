package com.ssm.service;

import com.ssm.entity.Clazz;

import java.util.List;

public interface ClazzService {
    List<Clazz> getAll(int pageNum,int pgeSize);
    List<Clazz> getAllByGradeid(int gradeid);
    Clazz getById(int id);
    void deleteByClazzById(int id);
    void insert(Clazz clazz);
    Clazz getClazzByName(String name);
}
