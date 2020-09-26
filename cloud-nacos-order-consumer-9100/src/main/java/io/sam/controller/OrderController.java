package io.sam.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import common.BaseResponse;
import io.sam.config.OrderConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Auther: zhuweimu
 * @Date: 2020/3/28 11:17
 * @Description:
 */
@RestController
@RequestMapping("order")
@RefreshScope
public class OrderController {

    @Value("${server.port}")
    private Integer port;

    @Value("${config.data}")
    private String data;

    @Autowired
    private OrderConfig orderConfig;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("getPaymentInfo")
    public BaseResponse getPaymentInfo(){
        ResponseEntity<BaseResponse> result = restTemplate.getForEntity(orderConfig.getPaymentService() + "/payment/getPaymentInfo", BaseResponse.class);
        return BaseResponse.success(result.getBody());
    }

    @SentinelResource(value = "getData",blockHandler = "exceptionHandler")
    @GetMapping(value = "getData")
    public BaseResponse getData(){
        return BaseResponse.success(data);
    }

    public BaseResponse exceptionHandler(BlockException ex){
        return BaseResponse.error(500,"兜底异常信息",null);
    }
}
