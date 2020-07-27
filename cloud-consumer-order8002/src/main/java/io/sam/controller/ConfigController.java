package io.sam.controller;

import common.BaseResponse;
import io.sam.config.DataConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: zhuweimu
 * @Date: 2020/7/26 17:35
 * @Description:
 */
@RestController
@RequestMapping("config/")
public class ConfigController {

    @Value("${server.port}")
    Integer post;

    @Autowired
    DataConfig dataConfig;

    @GetMapping("getConfigPort")
    public BaseResponse getConfigPort(){
        return BaseResponse.success(post);
    }

    @GetMapping("getDataConfig")
    public BaseResponse getDataConfig(){
        return BaseResponse.success(dataConfig);
    }
}
