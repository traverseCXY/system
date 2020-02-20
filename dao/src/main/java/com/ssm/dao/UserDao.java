package com.ssm.dao;

import com.ssm.entity.User;
import com.ssm.entity.System;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
    User getByID(String account, String password);

    System getMaxSystem();

    void deleteById(String number);

    void updateUser(User user);

    void insert(User user);

    void updateUserByaccount(User user);
}
