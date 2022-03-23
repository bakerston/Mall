package com.cz.mall.vo;

import java.math.BigDecimal;
import java.util.List;

import lombok.Data;

@Data
public class CartVo {
    private List<CartProductVo> cartProductVoList;

    private Boolean selectedAll;

    private BigDecimal cartTotalPrice;

    private Integer cartTotalQuantity;
}
