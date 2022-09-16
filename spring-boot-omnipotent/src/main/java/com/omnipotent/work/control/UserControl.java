package com.omnipotent.work.control;

import com.omnipotent.work.common.Results;
import com.omnipotent.work.entity.User;
import com.omnipotent.work.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("/user")
@RestController
public class UserControl {

    @Autowired
    UserService userService;

    @ResponseBody
    @PostMapping("/login")
    public Results res(User user){
        return userService.login(user);
    }

    @ResponseBody
    @PostMapping("/reg")
    public Results reg(User user){

        return userService.reg(user);
    }
}
