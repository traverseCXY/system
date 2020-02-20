package com.ssm.service.impl;

import com.ssm.dao.SystemDao;
import com.ssm.entity.System;
import com.ssm.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SystemServiceImpl implements SystemService {

    @Autowired
    private SystemDao systemDao;

    @Override
    public void update(String name, String value) {
        systemDao.update(name, value);
    }

    @Override
    public System getAll() {
        return systemDao.getAll();
    }
}
