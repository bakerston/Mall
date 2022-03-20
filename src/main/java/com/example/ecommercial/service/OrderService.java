package com.example.ecommercial.service;

import com.github.pagehelper.PageInfo;

import com.example.ecommercial.vo.OrderVo;
import com.example.ecommercial.vo.ResponseVo;

public interface OrderService {
    ResponseVo<OrderVo> create(Integer uid, Integer shippingId);

    ResponseVo<PageInfo> list(Integer uid, Integer pageNum, Integer pageSize);

    ResponseVo<OrderVo> detail(Integer uid, Long orderNo);

    ResponseVo cancel(Integer uid, Long orderNo);

    void paid(Long orderNo);
}
