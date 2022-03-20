package com.example.ecommercial.service;

import com.example.ecommercial.pojo.User;
import com.example.ecommercial.vo.ResponseVo;

public interface UserService {
    ResponseVo<User> register(User user);

    /**
     * Login
     * @param username
     * @param password
     * @return
     */

    ResponseVo<User> login(String username, String password);
}
