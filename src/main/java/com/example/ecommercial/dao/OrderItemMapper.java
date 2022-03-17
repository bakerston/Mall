package com.example.ecommercial.dao;

import com.example.ecommercial.pojo.OrderItem;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface OrderItemMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OrderItem record);

    int insertSelective(OrderItem record);

    OrderItem selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OrderItem record);

    int updateByPrimaryKey(OrderItem record);

    int insertList(@Param("orderItemList") List<OrderItem> orderItemList);

    List<OrderItem> selectByOrderNo(Long orderNo);

    List<OrderItem> selectByUid(Integer uid);
}
