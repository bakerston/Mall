package com.example.ecommercial.pojo;

import lombok.Data;
import java.util.Date;

@Data
public class Shipping {
    private Integer id;
    private Integer userId;

    private String receiverName;
    private String receiverProvince;
    private String receiverCity;
    private String receiverDistrict;
    private String receiverAddress;
    private String receiverZip;

    private String receiverPhone;
    private String receiverMobile;

    private Date createTime;
    private Date updateTime;
}
