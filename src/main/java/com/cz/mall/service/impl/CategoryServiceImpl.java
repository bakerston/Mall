package com.cz.mall.service.impl;

import com.cz.mall.dao.CategoryMapper;
import com.cz.mall.pojo.Category;
import com.cz.mall.service.CategoryService;

import com.cz.mall.vo.CategoryVo;
import com.cz.mall.vo.ResponseVo;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class CategoryServiceImpl {
    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public ResponseVo selectAll() {
        List<Category> categories = categoryMapper.selectAll();

        List<CategoryVo> categoryVoList = new ArrayList<>();

        for (Category category: categories) {
            if (category.getParentId() == 0) {
                categoryVoList.add(Category2CategoryVo(category));
            }
        }
        categoryVoList.sort(Comparator.comparing(CategoryVo::getSortOrder).reversed());

        findSubCategories(categoryVoList, categories);

        return ResponseVo.success(categoryVoList);
    }

    @Override
    public void findSubCategoryId(Integer id, Set<Integer> resultSet) {
        List<Category> categories = categoryMapper.selectAll();
        findSubCategoryId(id, resultSet, categories);
    }


    private void findSubCategoryId(Integer id, Set<Integer> resultSet, List<Category> categories) {
        for (Category category : categories) {
            if (category.getParentId().equals(id)) {
                resultSet.add(category.getId());
                findSubCategoryId(category.getId(), resultSet, categories);
            }
        }
    }

    private void findSubCategories(List<CategoryVo> categoryVoList, List<Category> categories) {
        for (CategoryVo categoryVo: categoryVoList) {
            List<CategoryVo> subCategoryVoList = new ArrayList<>();
            for (Category category: categories) {
                if (category.getParentId().equals(categoryVo.getId())) {
                    subCategoryVoList.add(Category2CategoryVo(category));
                }
            }
            subCategoryVoList.sort(Comparator.comparing(CategoryVo::getSortOrder).reversed());
            categoryVo.setSubCategories(subCategoryVoList);


            findSubCategories(subCategoryVoList, categories);

        }
    }

    private CategoryVo Category2CategoryVo(Category category) {
        CategoryVo categoryVo = new CategoryVo();
        BeanUtils.copyProperties(category, categoryVo);
        return categoryVo;
    }

}
