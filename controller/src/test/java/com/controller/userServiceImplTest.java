package com.controller;

import com.ssm.entity.User;
import com.ssm.service.UserService;
import config.AppConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.awt.dnd.MouseDragGestureRecognizer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class userServiceImplTest {

    @Autowired
    private UserService userService;

    @Test
    public void udpateUserPassword(){
        User user=new User();
        user.setAccount("admin");
        user.setPassword("111111");
        userService.updateUser(user);
    }
}
