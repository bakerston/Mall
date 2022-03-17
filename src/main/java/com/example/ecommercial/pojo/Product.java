package com.example.ecommercial.pojo;

import lombok.Data;
import java.util.Date;
import java.math.BigDecimal;

@Data
public class Product {
    private Integer id;
    private Integer categoryId;

    private String name;
    private String subtitle;
    private String detail;
    private String mainImage;
    private String subImage;

    private BigDecimal price;
    private Integer status;
    private Integer stock;

    private Date creatTime;
    private Date updateTime;
}
