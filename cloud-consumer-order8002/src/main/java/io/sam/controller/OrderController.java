package io.sam.controller;

import common.BaseResponse;
import common.BaseResponse01;
import dto.vo.PaymentVo;
import io.sam.constant.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Auther: zhuweimu
 * @Date: 2020/3/28 17:39
 * @Description:
 */
@RestController
@RequestMapping("order/")
public class OrderController {


    @Autowired
    RestTemplate restTemplate;

    /**
     * 获取订单支付信息
     * @param orderId 订单Id
     * @return
     */
    @GetMapping("getOrderPayment/{orderId}")
    public String getOrderPayment(@PathVariable Long orderId){
        ResponseEntity<String> forEntity = restTemplate.getForEntity(Constants.PAYMENT_DOMAIN + "/payment/get/" + orderId, String.class);
        return forEntity.getBody();
    }

    /**
     * 根据订单ID获取订单支付信息
     * @param orderId 订单Id
     * @menu 订单
     * @return
     */
    @GetMapping("getOrderPayment/detail/{orderId}")
    public BaseResponse getPayment(@PathVariable Long orderId){
        return BaseResponse.success(new PaymentVo());
    }

    /**
     * 根据订单ID获取订单支付信息
     * @param orderId 订单Id
     * @menu 订单
     * @return
     */
    @GetMapping("getOrderPayment/detail01/{orderId}")
    public BaseResponse01 getPayment01(@PathVariable Long orderId){
        return new BaseResponse01();
    }
}

