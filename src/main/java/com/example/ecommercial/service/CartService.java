package com.example.ecommercial.service;

import com.example.ecommercial.form.CartAddForm;
import com.example.ecommercial.form.CartUpdateForm;
import com.example.ecommercial.vo.CartVo;
import com.example.ecommercial.vo.ResponseVo;

public interface CartService {
    ResponseVo<CartVo> cartAdd(Integer uid, CartAddForm cartAddForm);

    ResponseVo<CartVo> list(Integer uid);

    ResponseVo<CartVo> update(Integer uid, Integer productId, CartUpdateForm cartUpdateForm);

    ResponseVo<CartVo> delete(Integer uid, Integer productId);

    ResponseVo<CartVo> selectAll(Integer uid);

    ResponseVo<CartVo> unSelectAll(Integer uid);

    ResponseVo<Integer> sum(Integer uid);
}
