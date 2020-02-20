package com.ssm.dao;

import com.ssm.entity.Result;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultDao {
    void insert(Result result);
}
