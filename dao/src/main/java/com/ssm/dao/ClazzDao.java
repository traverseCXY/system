package com.ssm.dao;

import com.ssm.entity.Clazz;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClazzDao {

    List<Clazz> getAll(@Param("pageNum")int pageNum,@Param("pageSize")int pageSize);

    List<Clazz> getAllByGradeid(int gradeid);

    Clazz getById(Integer id);

    void deleteByClazzId(int id);

    void insert(Clazz clazz);

     Clazz getClazzByName(String name);
}
