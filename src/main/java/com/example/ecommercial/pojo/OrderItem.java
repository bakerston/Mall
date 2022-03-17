package com.example.ecommercial.pojo;

import lombok.Data;
import java.util.Date;
import java.math.BigDecimal;

@Data
public class OrderItem {
    private Integer id;
    private Integer userId;
    private Integer productId;
    private Long orderNo;

    private String productImage;
    private String productName;

    private BigDecimal currentUnitPrice;
    private Integer quantity;
    private BigDecimal totalPrice;

    private Date createTime;
    private Date updateTime;
}
