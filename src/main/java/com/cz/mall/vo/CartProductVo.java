package com.cz.mall.vo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CartProductVo {
    private Integer productId;

    private Integer quantity;
    private String productName;
    private String productSubtitle;
    private String productMainImage;

    private BigDecimal productPrice;

    private Integer status;

    private BigDecimal productTotalPrice;
    private Integer productStock;
    private Boolean productSelected;

    public CartProductVo(Integer productId, Integer quantity, String productSubtitle,
                         String productName, String productMainImage, BigDecimal productPrice,
                         Integer status, BigDecimal productTotalPrice, Integer productStock,
                         Boolean productSelected) {
        this.productId = productId;
        this.quantity = quantity;
        this.productSubtitle = productSubtitle;
        this.productName = productName;
        this.productMainImage = productMainImage;

        this.productPrice = productPrice;
        this.status = status;
        this.productTotalPrice = productTotalPrice;
        this.productStock = productStock;
        this.productSelected = productSelected;
    }

}
