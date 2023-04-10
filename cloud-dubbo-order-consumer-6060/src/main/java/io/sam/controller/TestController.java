package io.sam.controller;


import common.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import model.UserInfo;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.UserService;

import java.util.List;

/**
 * @author zhuweimu
 * @classname TestController
 * @description
 * @date 2020/9/9 16:45
 */
@Slf4j
@RestController
@RequestMapping
public class TestController {

    @DubboReference
    UserService userServic;

    @GetMapping("/user/all")
    public BaseResponse test(){
        log.info("查询用户信息");
        List<UserInfo> userInfo = userServic.getUserInfo();
        return BaseResponse.success(userInfo.size());
    }

//    @GetMapping("/user/{id}")
    public BaseResponse testId(@PathVariable Integer id){
        log.info("查询用户信息:{}",id);
        return BaseResponse.success(userServic.getUserInfoById(id));
    }

    @GetMapping("/user/{age}")
    public BaseResponse testAge(@PathVariable Integer age){
        log.info("查询用户信息:{}",age);
        return BaseResponse.success(userServic.getUserInfoByAge(age));
    }
}
