package com.sam.service;

import com.sam.BaseTest;
import io.sam.service.IocServiceTest;
import io.sam.task.TestTask01;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.aop.framework.AopProxyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.MetricsEndpoint;

import java.util.Objects;

/**
 * @author zhuweimu
 * @classname AopProxyUtilsTest
 * @description
 * @date 2021/3/22 11:07
 */
@Slf4j
public class SpringAspectTest extends BaseTest {

    @Autowired
    IocServiceTest iocServiceTest;

    @Test
    public void testAspect() {
        iocServiceTest.test();
    }

    @Test
    public void testExposeProxy() {
        iocServiceTest.testExposeProxy();
    }

}
