package com.example.ecommercial.pojo;

import lombok.Data;
import java.util.Date;

@Data
public class Category {
    private Integer id;
    private Integer parentId;
    private Boolean status;
    private String name;
    private Integer sortOrder;
    private Date createTime;
    private Date updateTime;
}
