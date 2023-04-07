package com.sam.spring;

import com.sam.BaseTest;
import io.sam.service.AspectService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author zhuweimu
 * @description
 * @date 2023/4/7 15:47
 */
@Slf4j
public class AspectTest extends BaseTest {

    @Autowired
    AspectService aspectService;

    @Test
    public void testProceedingJoinPointWithArgs() {
        aspectService.logInfo("112");
    }

    @Test
    public void testBefore() {
        aspectService.before("112");
    }

    @Test
    public void testAfter() throws Exception {
        aspectService.after(true,"112");
    }

    @Test
    public void testAfterReturn() throws Exception {
        aspectService.afterReturn(false,"112");
    }

    @Test
    public void testAfterThrowing() throws Exception {
        log.info("testAfterThrowing:{}",aspectService.afterThrowing(false,"112"));
    }
}
