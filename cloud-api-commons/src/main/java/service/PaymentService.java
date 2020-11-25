package service;

import model.Payment;

/**
 * @author zhuweimu
 * @classname PaymentService
 * @description
 * @date 2020/11/25 9:49
 */
public interface PaymentService {

    Payment getPaymentById(Long id);
}
