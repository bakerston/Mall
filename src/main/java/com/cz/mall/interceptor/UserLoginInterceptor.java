package com.cz.mall.interceptor;

import com.cz.mall.consts.MallConst;
import com.cz.mall.exception.UserLoginException;
import com.cz.mall.pojo.User;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserLoginInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        User user = (User) request.getSession().getAttribute(MallConst.CURRENT_USER);
        if (user == null) {
            throw new UserLoginException();
        }
        return true;
    }
}
