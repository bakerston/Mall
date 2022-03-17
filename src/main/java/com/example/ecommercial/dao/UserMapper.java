package com.example.ecommercial.dao;
import com.example.ecommercial.pojo.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    int countByEmail(String email);

    int countByUsername(String username);

    User selectByUsername(String username);
}
