package com.cz.mall.controller;

import com.cz.mall.service.CategoryService;
import com.cz.mall.vo.ResponseVo;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;

import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "Category Api")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/categories")
    @Operation(summary = "Get all categories")
    public ResponseVo selectAll() {
        return categoryService.selectAll();
    }
}
