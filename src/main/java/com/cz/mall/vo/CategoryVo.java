package com.cz.mall.vo;

import java.util.List;
import lombok.Data;

@Data
public class CategoryVo {
    private Integer id;

    private Integer parentId;

    private String name;

    private Integer sortOrder;

    private List<CategoryVo> subCategories;

}
