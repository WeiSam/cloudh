package io.sam.controller;

import common.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.OrderService;
import service.PaymentService;

/**
 * @author zhuweimu
 * @description
 * @date 2022/1/19 14:10
 */

@Slf4j
@RestController
@RequestMapping("sam/dubbo/")
public class UserController {

    @DubboReference(version = "01")
    PaymentService paymentService;

    @Lazy
    @DubboReference
    OrderService orderService;

    @GetMapping("timeout/{seconds}")
    public BaseResponse timeout(@PathVariable Long seconds){
        log.info("调用paymentService");
        return BaseResponse.success(paymentService.getPaymentById(seconds));
    }

    @GetMapping("getOrder/{seconds}")
    public BaseResponse getOrder(@PathVariable Long seconds){
        log.info("调用orderService");
        return BaseResponse.success(orderService.getOrder(seconds));
    }
}
