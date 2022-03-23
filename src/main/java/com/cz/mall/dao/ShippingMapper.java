package com.cz.mall.dao;

import com.cz.mall.pojo.Shipping;
import org.apache.ibatis.annotations.Param;

import java.util.Set;
import java.util.List;

public interface ShippingMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Shipping record);

    int insertSelective(Shipping record);

    Shipping selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Shipping record);

    int updateByPrimaryKey(Shipping record);

    int deleteByIdAndUid(@Param("shippingId") Integer shippingId, @Param("uid") Integer uid);

    List<Shipping> selectByUid(@Param("uid") Integer uid);

    Shipping selectByIdAndUid(@Param("shippingId") Integer shippingId, @Param("uid") Integer uid);

    List<Shipping> selectByShippingIdSet(@Param("shippingIdSet") Set<Integer> shippingIdSet);
}
