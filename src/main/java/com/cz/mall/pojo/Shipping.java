package com.cz.mall.pojo;

import java.util.Date;
import java.math.BigDecimal;

import lombok.Data;

@Data
public class Shipping {
    private Integer id;

    private Integer userId;

    private String receiverName;
    private String receiverPhone;
    private String receiverMobile;
    private String receiverProvince;
    private String receiverCity;
    private String receiverDistrict;
    private String receiverAddress;

    private String receiverZip;
    private Date createTime;
    private Date updateTime;

}
