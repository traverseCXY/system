package com.ssm.service.impl;

import com.ssm.dao.ResultDao;
import com.ssm.entity.Result;
import com.ssm.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResultServiceImpl implements ResultService {

    @Autowired
    private ResultDao resultDao;
    @Override
    public void insert(Result result) {
        resultDao.insert(result);
    }
}
