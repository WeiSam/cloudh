package io.sam.service.impl;

import io.sam.annotation.DisLock;
import io.sam.enums.LockServiceType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author zhuweimu
 * @classname LockTestServiceImpl
 * @description
 * @date 2020/9/21 17:06
 */
@Slf4j
@Service
public class LockTestServiceImpl {

    @DisLock(prefix = "LockTestServiceImpl",key = "#key",lockServiceType = LockServiceType.CURATOR)
    public String getKey(String key){

        try {
            log.info("获取锁成功！！！");
            Thread.sleep(3000);
            log.info("执行成功！！");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "锁成功，key = "+key;
    }
}
