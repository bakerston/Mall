package com.example.ecommercial.pojo;

import lombok.Data;
import java.util.Date;
import java.math.BigDecimal;

@Data
public class Order {
    private Integer id;
    private Long orderNo;

    private Integer userId;
    private Integer shippingId;


    private BigDecimal payment;
    private Integer status;
    private Integer paymentType;
    private Integer postage;

    private Date createTime;
    private Date updateTime;
    private Date closeTime;
    private Date endTime;
    private Date sendTime;
    private Date paymentTime;

}
