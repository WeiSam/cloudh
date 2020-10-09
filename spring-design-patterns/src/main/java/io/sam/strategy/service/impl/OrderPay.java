package io.sam.strategy.service.impl;

import io.sam.strategy.factory.PayServiceFactory;
import io.sam.strategy.service.PayService;

/**
 * @author zhuweimu
 * @classname OrderPay
 * @description
 * @date 2020/10/3 17:02
 */
public class OrderPay {

    PayService payService;

    public OrderPay(PayService payService) {
        this.payService = payService;
    }

    public String pay(String payWay){
        PayService payService = PayServiceFactory.getPayService(payWay);
        return payService.pay();
    }

    public String pay(){
        return this.payService.pay();
    }
}
