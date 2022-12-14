package com.omnipotent.work.service.impl;

import com.omnipotent.work.common.Contants;
import com.omnipotent.work.common.Results;
import com.omnipotent.work.entity.User;
import com.omnipotent.work.mapper.UserMapper;
import com.omnipotent.work.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Objects;

@Service
public class UserSericeImpl implements UserService {
    @Resource
    private UserMapper userMapper;
    @Override
    public Results login(User user) {
        Results results = new Results();
        if (Objects.nonNull(user)) {
            User user1 = userMapper.selectByUsername(user);
            if (Objects.nonNull(user1)&&user1.getUsername().equals(user.getUsername())&&user1.getPassword().equals(user.getPassword())) {
               return results.setMsg(Contants.LONGIN_OK.getMsg()).setCode(Contants.LONGIN_OK.getCode());
            }
        }
        return results.setMsg(Contants.LONGIN_ERROR.getMsg()).setCode(Contants.LONGIN_ERROR.getCode());
    }

    @Override
    public Results reg(User user) {
        Results results = new Results();
        User user1 = userMapper.selectByUsername(user);
        if (!Objects.nonNull(user1)) {
            int i = userMapper.insertSelective(user);
            if (i > 0) {
                return results.setCode(Contants.REG_OK.getCode()).setMsg(Contants.REG_OK.getMsg());
            }
        } else {
            return results.setMsg("用户已存在！").setCode(Contants.REG_ERROR.getCode());
        }
        return results.setMsg(Contants.REG_ERROR.getMsg()+"!请联系管理员！QQ群 943989865").setCode(Contants.REG_ERROR.getCode());
    }
}
