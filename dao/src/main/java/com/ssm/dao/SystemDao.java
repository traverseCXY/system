package com.ssm.dao;

import com.ssm.entity.System;
import org.springframework.stereotype.Repository;

@Repository
public interface SystemDao {
    void update(String name,String value);
    System getAll();
}
