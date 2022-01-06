package com.sam.service;

import com.sam.BaseTest;
import io.sam.service.IocServiceTest;
import io.sam.service.TestAdvisorService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author zhuweimu
 * @classname AopProxyUtilsTest
 * @description
 * @date 2021/3/22 11:07
 */
@Slf4j
public class SpringAdvisortTest extends BaseTest {

    @Autowired
    TestAdvisorService testAdvisorService;

    @Test
    public void testAspect() {
        String advisorServiceClass = testAdvisorService.getAdvisorServiceClass();
        log.info("执行完成:{}",advisorServiceClass);
    }

}
