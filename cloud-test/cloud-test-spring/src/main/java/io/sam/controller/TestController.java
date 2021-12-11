package io.sam.controller;

import common.BaseResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

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

    @DeleteMapping(value = "/testmap/{fileName:.+}",produces = MediaType.APPLICATION_JSON_VALUE)
    public BaseResponse testmap(@PathVariable String fileName){
        return BaseResponse.success(fileName);
    }
}
