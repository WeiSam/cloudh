package io.sam.service;

import com.alibaba.fastjson.JSON;
import io.sam.BaseTest;
import io.sam.service.impl.LockTestServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import sam.ImportTestConfig;
import sam.TestModel;

import java.util.concurrent.TimeUnit;

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
        for (int i=0;i<3;i++){
            int finalI = 1+i*2;
            new Thread(() -> {
                try {
                    TimeUnit.SECONDS.sleep(finalI);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                log.info(lockTestService.getKey("123454"));
            }).start();
        }
        Thread.sleep(1000*100);
    }

    @Autowired
    TestModel testModel;

    @Autowired
    ImportTestConfig importTestConfig;

    @Test
    public void testImport(){
        log.info(JSON.toJSONString(testModel));
        log.info(JSON.toJSONString(importTestConfig));
    }
}
