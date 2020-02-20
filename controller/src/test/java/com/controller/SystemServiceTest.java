package com.controller;

import com.ssm.service.SystemService;
import config.AppConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class SystemServiceTest {

    @Autowired
    private SystemService systemService;

    @Test
    public void update(){
        //systemService.update("schoolName","456456");
    }
}
