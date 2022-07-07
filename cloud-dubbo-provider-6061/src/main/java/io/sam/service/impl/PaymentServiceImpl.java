package io.sam.service.impl;

import lombok.extern.slf4j.Slf4j;
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
@Slf4j
@DubboService(version = "01")
public class PaymentServiceImpl implements PaymentService {
    @Override
    public Payment getPaymentById(Long id) {
        log.info("PaymentServiceImpl");
        try {
            TimeUnit.SECONDS.sleep(id);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("io.sam.service.impl.PaymentServiceImpl执行结束");
        return Payment.builder().id(id).build();
    }
}
