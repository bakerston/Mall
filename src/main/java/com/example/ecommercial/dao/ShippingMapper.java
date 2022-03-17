package com.example.ecommercial.dao;

import com.example.ecommercial.pojo.Shipping;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

public interface ShippingMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Shipping record);

    int insertSelective(Shipping record);

    Shipping selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Shipping record);

    int updateByPrimaryKey(Shipping record);

    int deleteByIdAndUid(@Param("shipping") Integer shippingId, @Param("uid") Integer uid);

    Shipping selectByIdAndUid(@Param("shippingId") Integer shippingId, @Param("uid") Integer uid);

    List<Shipping> selectByShippingIdSet(@Param("shippingIdSet") Set<Integer> shippingIdSet);
}
