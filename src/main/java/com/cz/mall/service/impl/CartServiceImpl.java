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

        HashOperations<String, String, String> opsForHash = redisTemplate.opsForHash();
        String redisKey = String.format(CART_REDIS_KEY_TEMPLATE, uid);
        String value = opsForHash.get(redisKey, String.valueOf(product.getId()));
        Cart cart;
        if (!StringUtils.hasLength(value)) {
            cart = new Cart(product.getId(), quantity, cartAddForm.getSelected());
        } else {
            cart = JSON.parseObject(value, Cart.class);
            cart.setQuantity(cart.getQuantity() + quantity);
        }
        opsForHash.put(redisKey, String.valueOf(product.getId()), JSON.toJSONString(cart));
        return list(uid);
    }

    @Override
    public ResponseVo<CartVo> list(Integer uid) {
        CartVo cartVo = new CartVo();


        Set<Integer> productIdSet = new HashSet<>();

        List<CartProductVo> cartProductVoList = new ArrayList<>();
        List<Cart> cartList = new ArrayList<>();
        BigDecimal cartTotalPrice = BigDecimal.ZERO;
        Integer cartTotalQuantity = 0;
        Boolean isSelectedAll = true;

        //从redis中读取数据
        HashOperations<String, String, String> opsForHash = redisTemplate.opsForHash();
        String redisKey = String.format(CART_REDIS_KEY_TEMPLATE, uid);
        Map<String, String> entries = opsForHash.entries(redisKey);
        for (Map.Entry<String, String> entry : entries.entrySet()) {
            Integer productId = Integer.valueOf(entry.getKey());
            productIdSet.add(productId);

            Cart cart = JSON.parseObject(entry.getValue(), Cart.class);
            cartList.add(cart);
            cartTotalQuantity += cart.getQuantity();
            if (!cart.getProductSelected()) {
                isSelectedAll = false;
            }
        }

        List<Product> productList = productMapper.selectByProductIdSet(productIdSet);
        Map<Integer, Product> map = new HashMap<>();
        for (Product product : productList) {
            map.put(product.getId(), product);
        }
        for (Cart cart : cartList) {
            Product product = map.get(cart.getProductId());
            CartProductVo cartProductVo = new CartProductVo(product.getId(),
                    cart.getQuantity(),
                    product.getName(),
                    product.getSubtitle(),
                    product.getMainImage(),
                    product.getPrice(),
                    product.getStatus(),
                    product.getPrice().multiply(BigDecimal.valueOf(cart.getQuantity())),
                    product.getStock(),
                    cart.getProductSelected());
            cartProductVoList.add(cartProductVo);
            cartTotalPrice = cartTotalPrice.add(cartProductVo.getProductTotalPrice());
        }

        cartVo.setCartProductVoList(cartProductVoList);
        cartVo.setCartTotalPrice(cartTotalPrice);
        cartVo.setCartTotalQuantity(cartTotalQuantity);
        cartVo.setSelectedAll(isSelectedAll);
        return ResponseVo.success(cartVo);
    }

    @Override
    public ResponseVo<CartVo> update(Integer uid, Integer productId, CartUpdateForm cartUpdateForm) {
        HashOperations<String, String, String> opsForHash = redisTemplate.opsForHash();
        String value = opsForHash.get(String.format(CART_REDIS_KEY_TEMPLATE, uid), String.valueOf(productId));
        if (!StringUtils.hasLength(value)) {
            return ResponseVo.error(ResponseEnum.CART_PRODUCT_NOT_EXIST);
        }
        Cart cart = JSON.parseObject(value, Cart.class);

        if (cartUpdateForm.getQuantity() != null) {
            //修改购物车数量为0，删除该商品
            if (cartUpdateForm.getQuantity() == 0) {
                opsForHash.delete(String.format(CART_REDIS_KEY_TEMPLATE, uid), String.valueOf(productId));
                return list(uid);
            }

            if (cartUpdateForm.getQuantity() > 0) {
                cart.setQuantity(cartUpdateForm.getQuantity());
            }
        }

        if (cartUpdateForm.getSelected() != null) {
            cart.setProductSelected(cartUpdateForm.getSelected());
        }

        opsForHash.put(String.format(CART_REDIS_KEY_TEMPLATE, uid), String.valueOf(productId), JSON.toJSONString(cart));

        return list(uid);
    }

    @Override
    public ResponseVo<CartVo> delete(Integer uid, Integer productId) {
        HashOperations<String, String, String> opsForHash = redisTemplate.opsForHash();
        String value = opsForHash.get(String.format(CART_REDIS_KEY_TEMPLATE, uid), String.valueOf(productId));
        if (!StringUtils.hasLength(value)) {
            return ResponseVo.error(ResponseEnum.CART_PRODUCT_NOT_EXIST);
        }
        opsForHash.delete(String.format(CART_REDIS_KEY_TEMPLATE, uid), String.valueOf(productId));

        return list(uid);
    }

    @Override
    public ResponseVo<CartVo> selectAll(Integer uid) {
        HashOperations<String, String, String> opsForHash = redisTemplate.opsForHash();
        Map<String, String> entries = opsForHash.entries(String.format(CART_REDIS_KEY_TEMPLATE, uid));
        for (Map.Entry<String, String> entry : entries.entrySet()) {
            String value = entry.getValue();
            Cart cart = JSON.parseObject(value, Cart.class);
            cart.setProductSelected(true);
            entry.setValue(JSON.toJSONString(cart));
            opsForHash.put(String.format(CART_REDIS_KEY_TEMPLATE, uid), entry.getKey(), entry.getValue());
        }

        return list(uid);
    }

    @Override
    public ResponseVo<CartVo> unSelectAll(Integer uid) {
        HashOperations<String, String, String> opsForHash = redisTemplate.opsForHash();
        Map<String, String> entries = opsForHash.entries(String.format(CART_REDIS_KEY_TEMPLATE, uid));
        for (Map.Entry<String, String> entry : entries.entrySet()) {
            String value = entry.getValue();
            Cart cart = JSON.parseObject(value, Cart.class);
            cart.setProductSelected(false);
            entry.setValue(JSON.toJSONString(cart));
            opsForHash.put(String.format(CART_REDIS_KEY_TEMPLATE, uid), entry.getKey(), entry.getValue());
        }
        return list(uid);
    }

    @Override
    public ResponseVo<Integer> sum(Integer uid) {
        ResponseVo<CartVo> list = list(uid);
        Integer sum = list.getData().getCartTotalQuantity();
        return ResponseVo.success(sum);
    }


}
