package com.example.ecommercial.pojo;

import lombok.Data;

import java.util.Date;
import java.math.BigDecimal;

@Data
public class PayInfo {
    private Integer id;
    private Integer userId;
    private Long orderNo;

    private String platformNo;
    private Integer platform;
    private String platformStatus;

    private BigDecimal payAmount;

    private Date createTime;
    private Date updateTime;

    public PayInfo(Long orderNo, Integer platform, String platformStatus, BigDecimal payAmount) {
        this.orderNo = orderNo;
        this.platform = platform;
        this.platformStatus = platformStatus;
        this.payAmount = payAmount;
    }
}
