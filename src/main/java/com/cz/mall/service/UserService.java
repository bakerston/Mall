package com.cz.mall.service;

import com.cz.mall.pojo.User;
import com.cz.mall.vo.ResponseVo;

public interface UserService {
    ResponseVo<User> register(User user);

    ResponseVo<User> login(String username, String password);
}
