package com.cz.mall.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.cz.mall.enums.ResponseEnum;

import lombok.Data;
import org.springframework.validation.BindingResult;

@Data
@JsonInclude(value=JsonInclude.Include.NON_NULL)
public class ResponseVo<T> {
    private Integer status;

    private String msg;

    private T data;

    public ResponseVo(Integer status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public ResponseVo(Integer status, T data) {
        this.status = status;
        this.data = data;
    }

    public ResponseVo(Integer status, String msg, T data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public static <T> ResponseVo<T> success(T data) {
        return new ResponseVo<>(ResponseEnum.SUCCESS.getCode(), data);
    }

    public static ResponseVo success() {
        return new ResponseVo(ResponseEnum.SUCCESS.getCode(), ResponseEnum.SUCCESS.getDesc());
    }

    public static <T> ResponseVo<T> success(String msg, T data) {
        return new ResponseVo<>(ResponseEnum.SUCCESS.getCode(), msg, data);
    }

    public static ResponseVo successByMsg(String msg) {
        return new ResponseVo(ResponseEnum.SUCCESS.getCode(), msg);
    }

    public static ResponseVo error(ResponseEnum responseEnum, String msg) {
        return new ResponseVo(responseEnum.getCode(), msg);
    }

    public static ResponseVo error(ResponseEnum responseEnum) {
        return new ResponseVo(responseEnum.getCode(), responseEnum.getDesc());
    }

    public static ResponseVo error(ResponseEnum responseEnum, BindingResult bindingResult) {
        return new ResponseVo(responseEnum.getCode(), bindingResult.getFieldError().getField() + " " + bindingResult.getFieldError().getDefaultMessage());
    }
}
