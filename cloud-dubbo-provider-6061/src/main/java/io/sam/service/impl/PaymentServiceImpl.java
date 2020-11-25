package io.sam.service.impl;

import model.Payment;
import org.apache.dubbo.config.annotation.DubboService;
import service.PaymentService;

/**
 * @author zhuweimu
 * @classname PaymentServiceImpl
 * @description
 * @date 2020/11/25 9:51
 */
@DubboService(version = "01")
public class PaymentServiceImpl implements PaymentService {
    @Override
    public Payment getPaymentById(Long id) {
        return Payment.builder().id(id).build();
    }
}
