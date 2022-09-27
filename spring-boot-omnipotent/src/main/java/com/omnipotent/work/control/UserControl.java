package com.omnipotent.work.control;

import com.alibaba.fastjson.JSONObject;
import com.omnipotent.work.common.Results;
import com.omnipotent.work.entity.User;
import com.omnipotent.work.service.UserService;
import com.omnipotent.work.service.impl.RedisServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@SuppressWarnings("all")
@RequestMapping("/user")
@RestController
public class UserControl {

    @Autowired
    UserService userService;
    @Autowired
    RedisServiceImpl redisService;

    @ResponseBody
    @PostMapping("/login")
    public Results login( User user, HttpServletRequest request) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(request.getInputStream()));
        String s = reader.readLine();
        JSONObject jsonObject = JSONObject.parseObject(s);
        String data = jsonObject.getString("data");
        jsonObject = JSONObject.parseObject(data);
        String username = jsonObject.getString("username");
        String password = jsonObject.getString("password");
        String pnum = jsonObject.getString("pnum");
        String cookie = jsonObject.getString("cookie");
        user.setUsername(username);
        user.setPassword(password);
        System.out.println("用户redis KEy："+cookie);
        Object code = redisService.getValue(cookie);
        System.out.println(pnum.toLowerCase() + "=="+code.toString().toLowerCase());
        if (!pnum.toLowerCase().equals(code.toString().toLowerCase())) {
            return new Results().setCode(-1).setMsg("验证码错误！如多次错误，请点击更换下一张！");
        }
        return userService.login(user);
    }

    @ResponseBody
    @PostMapping("/reg")
    public Results reg(User user,HttpServletRequest request) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(request.getInputStream()));
        String s = reader.readLine();
        JSONObject jsonObject = JSONObject.parseObject(s);
        String data = jsonObject.getString("data");
        jsonObject = JSONObject.parseObject(data);
        String username = jsonObject.getString("username");
        String password = jsonObject.getString("password");
        String pnum = jsonObject.getString("pnum");
        String cookie = jsonObject.getString("cookie");
        user.setUsername(username);
        user.setPassword(password);
        //默认用户名为昵称
        user.setNickname(username);
        System.out.println("用户redis KEy："+cookie);
        Object code = redisService.getValue(cookie);
        System.out.println(code.toString());
        if (!pnum.toLowerCase().equals(code.toString().toLowerCase())) {
            return new Results().setCode(-1).setMsg("验证码错误！如多次错误，请点击更换下一张！");
        }
        return userService.reg(user);
    }
}
