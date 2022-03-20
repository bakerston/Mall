package com.example.ecommercial.service;

import com.example.ecommercial.vo.ResponseVo;
import java.util.Set;

public interface CategoryService {
    ResponseVo selectAll();
    void findSubCategoryId(Integer id, Set<Integer> resultSet);
}
