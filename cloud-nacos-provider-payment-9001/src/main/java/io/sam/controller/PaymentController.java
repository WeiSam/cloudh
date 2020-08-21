package io.sam.controller;

import com.alibaba.fastjson.JSON;
import common.BaseResponse;
import model.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * @Auther: zhuweimu
 * @Date: 2020/3/28 11:17
 * @Description:
 */
@RestController
@RequestMapping("payment")
public class PaymentController {

    @Value("${server.port}")
    private Integer post;

    /**
     * 新增流水信息
     * @param payment
     * @menu 支付流水
     * @return
     */
    @PostMapping("/add")
    public String insertPayment(@RequestBody Payment payment){
        System.out.println("新增成功,payment = "+ JSON.toJSONString(payment));
        return "suceess";
    }

    /**
     * 根据ID获取流水信息
     * @param id 流水ID
     * @menu 支付流水
     * @return
     */
    @GetMapping("/get/{id}")
    public String getPayment(@PathVariable Long id){
        System.out.println("查询,id = "+ id);
        Payment payment  = Payment.builder().id(id).serial("7238sjdh").build();
        return "服务端口："+post+"\n"+JSON.toJSONString(payment);
    }

    @GetMapping("getPaymentInfo")
    public BaseResponse getPaymentInfo(){
        return BaseResponse.success("支付服务，当前端口号："+post);
    }

}
