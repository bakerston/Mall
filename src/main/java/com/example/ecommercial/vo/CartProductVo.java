package com.example.ecommercial.vo;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class CartProductVo {
    private Integer productId;

    private Integer quantity;

    private String productName;
    private String productMainImage;
    private String productSubtitle;

    private BigDecimal productPrice;

    private Integer status;

    private BigDecimal productTotalPrice;

    private Integer productStock;

    private Boolean productSelected;

    public CartProductVo(Integer productId, Integer quantity, String productName,
                         String productMainImage, String productSubtitle, BigDecimal productPrice,
                         Integer status, BigDecimal productTotalPrice, Integer productStock,
                         Boolean productSelected) {
        this.productId = productId;
        this.quantity = quantity;
        this.productName = productName;
        this.productMainImage = productMainImage;
        this.productSubtitle = productSubtitle;
        this.productPrice = productPrice;
        this.status = status;
        this.productTotalPrice = productTotalPrice;
        this.productStock = productStock;
        this.productSelected = productSelected;
    }

}
