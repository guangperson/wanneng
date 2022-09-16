package com.omnipotent.work.service;

import com.omnipotent.work.common.Results;
import com.omnipotent.work.entity.User;
import org.springframework.stereotype.Service;


public interface UserService {

    Results login(User user);

    Results reg(User user);
}
