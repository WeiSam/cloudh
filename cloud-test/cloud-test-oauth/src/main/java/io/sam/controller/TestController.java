package io.sam.controller;

import common.BaseResponse;
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

    @Value("${test.name}")
    private String name;

    @GetMapping(value = "getName")
    public BaseResponse testName(){
        return BaseResponse.success(name);
    }
}
