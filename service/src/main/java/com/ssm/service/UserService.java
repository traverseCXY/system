package com.ssm.service;

import com.ssm.entity.System;
import com.ssm.entity.User;

public interface UserService {
    User getByID(String account,String password);
    System getMaxSystem();
    void deleteById(String number);
    void updateUser(User user);
    void insert(User user);
    void updateUserByaccount(User user);
}
