package com.cz.mall.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class CartAddForm {
    @NotNull
    private Integer productId;

    private Boolean selected=true;

}
