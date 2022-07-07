package io.sam.controller;

import common.BaseResponse;
import org.java_websocket.client.WebSocketClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhuweimu
 * @classname TestController
 * @description
 * @date 2021/1/8 11:36
 */
@RestController
@RequestMapping(value = "/test/")
public class TestController {

    @Autowired
    WebSocketClient webSocketClient;

    @Value("${test.name}")
    private String name;

    @GetMapping(value = "getName")
    public BaseResponse testName(){
        return BaseResponse.success(name);
    }

    @GetMapping(value = "sendMsg/{msg}")
    public BaseResponse sendMsg(String msg){

        return BaseResponse.success();
    }
}
