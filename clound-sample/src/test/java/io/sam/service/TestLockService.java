package io.sam.service;

import io.sam.BaseTest;
import io.sam.service.impl.LockTestServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author zhuweimu
 * @classname TestLockService
 * @description
 * @date 2020/9/21 17:11
 */
@Slf4j
public class TestLockService extends BaseTest {

    @Autowired
    LockTestServiceImpl lockTestService;

    @Test
    public void testLock() throws InterruptedException {
        for (int i=0;i<10;i++){
            new Thread(() -> {
                log.info(lockTestService.getKey("123454"));
            }).start();
        }
        Thread.sleep(1000*100);

    }
}
