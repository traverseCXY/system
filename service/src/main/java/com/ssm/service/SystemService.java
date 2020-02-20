package com.ssm.service;

import com.ssm.entity.System;

public interface SystemService {
    void update(String name,String value);
    System getAll();
}
