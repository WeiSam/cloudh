package io.sam.controller;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSON;
import common.BaseResponse;
import io.sam.db.service.AccountTblService;
import io.sam.dto.ChongqingRequest;
import io.sam.dto.YanTaiLoginReq;
import io.sam.dto.YanTaiLoginResp;
import io.sam.dto.YanTaiRepositoryResp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.*;

import javax.servlet.AsyncContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.UUID;

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
        String str = "{ \"success\": true, \"code\": 200, \"msg\": \"success\", \"data\": { \"id\": \"ff471d56-2e99-42e7-982f-3515cf322221\", \"loginId\": \"88888888\", \"userName\": \"test2\", \"deleted\": 0, \"position\": \"test2\", \"userType\": 5, \"departmentId\": \"1\", \"deptCode\": \"9900\", \"secondLevelUnits\": \"\",\"threeLevelUnits\": \"\" } }";
        return str.replaceAll("88888888",accessToken);
    }


}
