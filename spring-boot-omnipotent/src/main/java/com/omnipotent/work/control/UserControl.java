package com.omnipotent.work.control;

import com.alibaba.fastjson.JSONObject;
import com.omnipotent.work.common.Results;
import com.omnipotent.work.entity.User;
import com.omnipotent.work.service.UserService;
import com.omnipotent.work.service.impl.RedisServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


@RequestMapping("/user")
@RestController
public class UserControl {

    @Autowired
    UserService userService;
    @Autowired
    RedisServiceImpl redisService;
    @ResponseBody
    @PostMapping("/login")
    public Results res(User user, HttpServletRequest request) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(request.getInputStream()));
        String s = reader.readLine();
        JSONObject jsonObject = JSONObject.parseObject(s);
        String data = jsonObject.getString("data");
        jsonObject = JSONObject.parseObject(data);
        String username = jsonObject.getString("username");
        String password = jsonObject.getString("password");
        String pnum = jsonObject.getString("pnum");
        user.setUsername(username);
        user.setPassword(password);

        Object code = redisService.getValue("code");
        if (!pnum.equals(code)) {
            return new Results().setCode(-1).setMsg("验证码错误！");
        }
        return userService.login(user);
    }

    @ResponseBody
    @PostMapping("/reg")
    public Results reg(User user){

        return userService.reg(user);
    }
}
