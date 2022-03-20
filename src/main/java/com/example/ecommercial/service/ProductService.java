package com.example.ecommercial.service;

import com.github.pagehelper.PageInfo;
import com.example.ecommercial.vo.ProductDetailVo;
import com.example.ecommercial.vo.ProductVo;
import com.example.ecommercial.vo.ResponseVo;

import java.util.List;

public interface ProductService {
    ResponseVo<PageInfo> list(Integer categoryId, Integer pageNum, Integer pageSize);

    ResponseVo<ProductDetailVo> detail(Integer productId);

}
