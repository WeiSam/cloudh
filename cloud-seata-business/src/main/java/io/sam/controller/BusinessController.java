package io.sam.controller;

import io.sam.service.BusinessService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author: zhuweimu
 * @Date: 2020/8/2 16:03
 * @Description:
 */
@RestController
@RequestMapping
@Slf4j
public class BusinessController {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    BusinessService businessService;

    @GetMapping("/purchase/{isRollback}")
    public String purchase(@PathVariable Integer isRollback){
        try {
            if (isRollback == 1) {
                businessService.purchase("U100000", "C100000", 99999);
            }else {
                businessService.purchase("U100000", "C100000", 30);
            }
        }catch (Exception e){
            log.error("异常：",e);
            return e.getMessage();
        }
        return "创建成功";

    }
}
