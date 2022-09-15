package com.omnipotent.work.control;

import com.omnipotent.work.common.Results;
import com.omnipotent.work.entity.User;
import com.omnipotent.work.mapper.UserMapper;
import com.omnipotent.work.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RequestMapping("/user")
@RestController
public class control {

    @Autowired
    UserService userService;

    @ResponseBody
    @RequestMapping("/login")
    public Results res(User user){
        return userService.login(user);
    }
}
