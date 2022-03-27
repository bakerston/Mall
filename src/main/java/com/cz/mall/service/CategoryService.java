package com.cz.mall.service;

import com.cz.mall.vo.ResponseVo;

import java.util.Set;

public interface CategoryService {
    ResponseVo selectAll();

    void findSubCategoryId(Integer id, Set<Integer> resultSet);

}
