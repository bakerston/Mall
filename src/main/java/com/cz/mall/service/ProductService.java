package com.cz.mall.service;

import com.github.pagehelper.PageInfo;

import com.cz.mall.vo.ProductDetailVo;
import com.cz.mall.vo.ProductVo;
import com.cz.mall.vo.ResponseVo;

import java.util.List;

public interface ProductService {
    ResponseVo<PageInfo> list(Integer categoryId, Integer pageNum, Integer pageSize);

    ResponseVo<ProductDetailVo> detail(Integer productId);
}
