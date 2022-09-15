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
               return results.setData(user1).setMsg(Contants.LONGIN_OK.getMsg()).setCode(Contants.LONGIN_OK.getCode());
            }
        }
        return results.setMsg(Contants.LONGIN_ERROR.getMsg()).setCode(Contants.LONGIN_ERROR.getCode());
    }
}
