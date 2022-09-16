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