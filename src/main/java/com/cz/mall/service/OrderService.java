package com.cz.mall.service;

import com.github.pagehelper.PageInfo;

import com.cz.mall.vo.OrderVo;
import com.cz.mall.vo.ResponseVo;

public interface OrderService {
    ResponseVo<OrderVo> create(Integer uid, Integer shippingId);

    ResponseVo<PageInfo> list(Integer uid, Integer pageNum, Integer pageSize);

    ResponseVo<OrderVo> detail(Integer uid, Long orderNo);

    ResponseVo cancel(Integer uid, Long orderNo);

    void paid(Long orderNo);

}
