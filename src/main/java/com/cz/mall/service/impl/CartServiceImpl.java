package com.cz.mall.service.impl;

import com.alibaba.fastjson.JSON;

import com.cz.mall.dao.ProductMapper;

import com.cz.mall.enums.ProductStatusEnum;
import com.cz.mall.enums.ResponseEnum;

import com.cz.mall.form.CartAddForm;
import com.cz.mall.form.CartUpdateForm;

import com.cz.mall.pojo.Cart;
import com.cz.mall.pojo.Product;
import com.cz.mall.service.CartService;
import com.cz.mall.vo.CartProductVo;
import com.cz.mall.vo.CartVo;
import com.cz.mall.vo.ResponseVo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.*;

public class CartServiceImpl {
    private static final String CART_REDIS_KEY_TEMPLATE = "cart_%d";

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    public ResponseVo<CartVo> cartAdd(Integer uid, CartAddForm cartAddForm) {
        Integer quantity = 1;
        Product product = productMapper.selectByPrimaryKey(cartAddForm.getProductId());

        // If product doesn't exist
        if (product == null) {
            return ResponseVo.error(ResponseEnum.PRODUCT_NOT_EXIST);
        }

        // If product NOT is in sale
        if (product.getStatus().equals(ProductStatusEnum.OFF_SALE.getCode()) || product.getStatus().equals(ProductStatusEnum.DELETE.getCode())) {
            return ResponseVo.error(ResponseEnum.PRODUCT_OFF_SALE_OR_DELETE);
        }

        // If product is out of stock
        if (product.getStock() < 0) {
            return ResponseVo.error(ResponseEnum.PRODUCT_STOCK_ERROR);
        }

    

    }

}
