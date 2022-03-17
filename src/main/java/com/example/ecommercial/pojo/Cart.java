package com.example.ecommercial.pojo;

import com.sun.org.apache.xpath.internal.operations.Bool;
import lombok.Data;

@Data
public class Cart {
    private Integer productId;
    private Integer quantity;
    private Boolean productSelected;

    public Cart(Integer productId, Integer quantity, Boolean productSelected) {
        this.productId = productId;
        this.quantity = quantity;
        this.productSelected = productSelected;
    }

    public Cart() {
    }

}
