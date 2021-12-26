package io.sam.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.framework.AopContext;
import org.springframework.stereotype.Service;

/**
 * @author zhuweimu
 * @description
 * @date 2021/5/26 17:11
 */
@Slf4j
@Service
public class IocServiceTest {

    public String test(){
        log.info("===========aaaaaaaaaaaaaaaaaa==========");
        return "test";
    }

    public void testExposeProxy(){
        log.info("执行testExposeProxy");
        ((IocServiceTest)AopContext.currentProxy()).test();

    }
}
