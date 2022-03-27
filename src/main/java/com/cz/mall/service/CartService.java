package com.cz.mall.service;

import com.cz.mall.form.CartAddForm;
import com.cz.mall.form.CartUpdateForm;

import com.cz.mall.vo.CartVo;
import com.cz.mall.vo.ResponseVo;

public interface CartService {
    ResponseVo<CartVo> cartAdd(Integer uid, CartAddForm cartAddForm);

    ResponseVo<CartVo> list(Integer uid);

    ResponseVo<CartVo> delete(Integer uid, Integer productId);

    ResponseVo<CartVo> update(Integer uid, Integer productId, CartUpdateForm cartUpdateForm);

    ResponseVo<CartVo> selectAll(Integer uid);

    ResponseVo<CartVo> unSelectAll(Integer uid);

    ResponseVo<Integer> sum(Integer uid);


}
