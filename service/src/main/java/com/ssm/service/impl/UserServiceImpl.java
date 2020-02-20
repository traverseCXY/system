package com.ssm.service.impl;

import com.ssm.dao.UserDao;
import com.ssm.entity.System;
import com.ssm.entity.User;
import com.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public User getByID(String account, String password) {
        return userDao.getByID(account,password);
    }

    @Override
    public System getMaxSystem() {
        return userDao.getMaxSystem();
    }

    @Override
    public void deleteById(String number) {
        userDao.deleteById(number);
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    public void insert(User user) {
        userDao.insert(user);
    }

    @Override
    public void updateUserByaccount(User user) {
        userDao.updateUserByaccount(user);
    }

}
