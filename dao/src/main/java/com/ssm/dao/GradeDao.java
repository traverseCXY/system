package com.ssm.dao;

import com.ssm.entity.Clazz;
import com.ssm.entity.Grade;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GradeDao {
    List<Grade> getAllGrade(@Param("pageNum")int pageNum,@Param("pageSize")int pageSize);
    List<Grade> getAll();
    Grade getById(Integer id);
    void update(Grade grade);
    void deleteByGradeId(Integer id);
    int insert(Grade grade);
    Grade getGradeByName(String name);
}
