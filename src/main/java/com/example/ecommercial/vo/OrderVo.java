package com.example.ecommercial.vo;

import com.example.ecommercial.pojo.Shipping;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;
import java.util.Date;

@Data
public class OrderVo {
    private Long orderNo;

    private BigDecimal payment;

    private Integer paymentType;

    private Integer postage;
    private Integer status;

    private Date paymentTime;
    private Date sendTime;
    private Date closeTime;
    private Date createTime;
    private Date endTime;

    private List<OrderItemVo> orderItemVoList;

    private Integer shippingId;

    private Shipping shippingVo;
}
