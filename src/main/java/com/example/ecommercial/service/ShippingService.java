package com.example.ecommercial.service;

import com.example.ecommercial.form.ShippingForm;
import com.example.ecommercial.vo.ResponseVo;
import com.github.pagehelper.PageInfo;

import java.util.Map;

public interface ShippingService {
    ResponseVo<Map<String, Integer>> add(Integer uid, ShippingForm shippingForm);

    ResponseVo delete(Integer uid, Integer shippingId);

    ResponseVo update(Integer uid, Integer shippingId, ShippingForm shippingForm);

    ResponseVo<PageInfo> list(Integer uid, Integer pageNum, Integer pageSize);
}
