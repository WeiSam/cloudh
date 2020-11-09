package io.sam.controller;

import common.BaseResponse;
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
@RequestMapping("sam/config/")
public class ConfigController {

    @Value("${server.port}")
    Integer post;

    @GetMapping("getConfigPort")
    public BaseResponse getConfigPort(){
        return BaseResponse.success(post);
    }

}
