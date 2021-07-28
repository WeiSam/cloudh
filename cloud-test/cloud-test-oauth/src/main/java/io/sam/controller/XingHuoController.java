package io.sam.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhuweimu
 * @classname TestController
 * @description
 * @date 2020/9/9 16:45
 */
@Slf4j
@RestController
@RequestMapping
public class XingHuoController {


    @GetMapping("/sso/v1/api/user")
    public String testCache(@RequestParam("access_token") String accessToken){
        log.info("access_token = {}",accessToken);
        String str = "{ \"success\": true, \"code\": 200, \"msg\": \"success\", \"data\": { \"id\": \"ff471d56-2e99-42e7-982f-3515cf322221\", \"loginId\": \"8848\", \"userName\": \"test2\", \"deleted\": 0, \"position\": \"test2\", \"userType\": 5, \"departmentId\": \"1\", \"deptCode\": \"9900\", \"secondLevelUnits\": \"\",\"threeLevelUnits\": \"\" } }";
        return str;
    }


}
