package io.sam.service.impl;

import model.Payment;
import org.apache.dubbo.config.annotation.DubboService;
import service.PaymentService;

import java.util.concurrent.TimeUnit;

/**
 * @author zhuweimu
 * @classname PaymentServiceImpl
 * @description
 * @date 2020/11/25 9:51
 */
@DubboService(version = "02")
public class PaymentServiceImpl02 implements PaymentService {
    @Override
    public Payment getPaymentById(Long id) {
        try {
            TimeUnit.SECONDS.sleep(id);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return Payment.builder().id(id+100000).build();
    }
}
