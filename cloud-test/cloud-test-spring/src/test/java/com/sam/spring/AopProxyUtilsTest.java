package com.sam.spring;

import com.sam.BaseTest;
import io.sam.task.TestTask01;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.aop.framework.AopProxyUtils;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author zhuweimu
 * @classname AopProxyUtilsTest
 * @description
 * @date 2021/3/22 11:07
 */
@Slf4j
public class AopProxyUtilsTest extends BaseTest {

    @Autowired
    TestTask01 testTask01;

    @Test
    public void testUltimateTargetClass(){
        //获取代理对象最终的对象类型
        Class<?> targetClass = AopProxyUtils.ultimateTargetClass(testTask01);
        log.info("testTask01:{}",targetClass);

    }
}
