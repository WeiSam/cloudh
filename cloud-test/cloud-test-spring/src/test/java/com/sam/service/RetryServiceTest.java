package com.sam.service;

import com.sam.BaseTest;
import io.sam.service.RetryTestService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author zhuweimu
 * @description
 * @date 2021/9/6 9:42
 */
@Slf4j
public class RetryServiceTest extends BaseTest {

    @Autowired
    RetryTestService retryTestService;

    @Test
    public void testRetry() {
        for (int i = 0; i < 1; i++) {
            try {
                String user = retryTestService.getUser(i);
            } catch (Exception e) {
                log.error("异常,i = {}",i);
            }
        }
    }
}
