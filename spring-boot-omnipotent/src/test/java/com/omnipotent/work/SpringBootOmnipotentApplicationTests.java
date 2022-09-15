package com.omnipotent.work;

import com.omnipotent.work.entity.User;
import com.omnipotent.work.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class SpringBootOmnipotentApplicationTests {
    @Autowired
    UserMapper userMapper;
    @Test
    void contextLoads() {
        User user = userMapper.selectByPrimaryKey(1);
        System.out.println(user);
    }

}
