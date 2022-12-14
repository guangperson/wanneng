package com.omnipotent.work.mapper;

import com.omnipotent.work.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {
    @Autowired
    UserMapper userMapper;
    @Test
    public void selectByPrimaryKey() {
        User user = userMapper.selectByPrimaryKey(1);
        System.out.println(user);
    }
}