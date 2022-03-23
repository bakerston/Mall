package com.cz.mall.vo;

import java.util.Date;
import java.math.BigDecimal;

import lombok.Data;

@Data
public class OrderItemVo {
    private Long orderNo;
    private Integer productId;

    private String productName;
    private String productImage;

    private BigDecimal currentUnitPrice;

    private Integer quantity;

    private BigDecimal totalPrice;

    private Date createTime;
}
