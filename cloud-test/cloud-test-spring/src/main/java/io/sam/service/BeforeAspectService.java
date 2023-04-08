package io.sam.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author zhuweimu
 * @description
 * @date 2023/4/7 16:27
 */
@Slf4j
@Service
public class BeforeAspectService {

    public String beforeAspectService(String name){
        log.info("eforeAspectService.beforeAspectService:{}",name);
        return "OK";
    }
}
