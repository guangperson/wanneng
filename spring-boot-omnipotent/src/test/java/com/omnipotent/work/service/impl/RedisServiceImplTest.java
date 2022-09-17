package com.omnipotent.work.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisServiceImplTest {
    @Autowired
    RedisServiceImpl redisService;
    @Test
    public void setValue() {
        redisService.setValue("qqq","你好，世界！");
        Object qqq = redisService.getValue("qqq");
        System.out.println(qqq);
    }

    @Test
    public void getValue() {
    }

    @Test
    public void testSetValue() {
    }

    @Test
    public void testSetValue1() {
    }

    @Test
    public void getMapValue() {
    }
}