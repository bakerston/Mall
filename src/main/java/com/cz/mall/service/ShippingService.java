package com.cz.mall.service;

import com.github.pagehelper.PageInfo;
import com.cz.mall.form.ShippingForm;
import com.cz.mall.vo.ResponseVo;

import java.util.Map;

public interface ShippingService {
    ResponseVo<Map<String, Integer>> add(Integer uid, ShippingForm shippingForm);

    ResponseVo delete(Integer uid, Integer shippingId);

    ResponseVo update(Integer uid, Integer shippingId, ShippingForm shippingForm);

    ResponseVo<PageInfo> list(Integer uid, Integer pageNum, Integer pageSize);

}
