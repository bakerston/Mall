package com.example.ecommercial.enums;

import lombok.Getter;

@Getter
public enum UserRoleEnum {

    ADMIN(0),
    CUSTOMER(1),
    ;

    Integer code;

    UserRoleEnum(Integer code) {
        this.code = code;
    }
}
