package com.cz.mall.vo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import lombok.Data;
import com.cz.mall.pojo.Shipping;

@Data
public class OrderVo {
    private Long orderNo;

    private BigDecimal payment;

    private Integer paymentType;
    private Integer postage;
    private Integer status;

    private Date paymentTime;
    private Date sendTime;
    private Date endTime;
    private Date closeTime;
    private Date createTime;

    private List<OrderItemVo> orderItemVoList;

    private Integer shippingId;
    private Shipping shippingVo;

}
