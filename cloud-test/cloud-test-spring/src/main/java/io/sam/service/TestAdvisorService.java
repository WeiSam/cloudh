package io.sam.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author zhuweimu
 * @description
 * @date 2021/8/3 16:41
 */
@Slf4j
@Service
public class TestAdvisorService {

    public String getAdvisorServiceClass(){
        log.info("getAdvisorServiceClass run");
        return TestAdvisorService.class.getName();
    }
}
