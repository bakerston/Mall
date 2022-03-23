package com.cz.mall.dao;

import com.cz.mall.pojo.OrderItem;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderItemMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OrderItem record);

    int insertSelective(OrderItem record);

    OrderItem selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OrderItem record);

    int updateByPrimaryKey(OrderItem record);

    int insertList(@Param("orderItemList") List<OrderItem> orderItemList);

    List<OrderItem> selectByUid(Integer uid);

    List<OrderItem> selectByOrderNo(Long orderNo);
}
