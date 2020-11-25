package io.sam.dubbo;

import com.alibaba.fastjson.JSON;
import io.sam.BaseTest;
import model.Payment;
import org.apache.dubbo.config.annotation.DubboReference;
import org.junit.Test;
import service.PaymentService;

/**
 * @author zhuweimu
 * @classname DubboTest
 * @description
 * @date 2020/11/25 10:05
 */
public class DubboTest extends BaseTest {

    @DubboReference(version = "02")
    PaymentService paymentService;

    @Test
    public void testPayment() {
        Payment payment = paymentService.getPaymentById(12L);
        System.out.println(JSON.toJSONString(payment));
    }
}
