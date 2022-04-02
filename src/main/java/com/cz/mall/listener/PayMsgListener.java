package com.cz.mall.listener;

import com.alibaba.fastjson.JSON;
import com.cz.mall.pojo.PayInfo;
import com.cz.mall.service.OrderService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
@RabbitListener(queues = "payNotify")
public class PayMsgListener {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private OrderService orderService;

    @RabbitHandler
    public void process(String msg) {
        logger.info("[New info] => {}", msg);
        PayInfo payInfo = JSON.parseObject(msg, PayInfo.class);
        if (payInfo.getPlatformStatus().equals("SUCCESS")) {
            orderService.paid(payInfo.getOrderNo());
        }
    }
}
