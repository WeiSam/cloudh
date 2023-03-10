package io.sam.service.impl;

import common.BaseResponse;
import io.sam.annotation.DisLock;
import io.sam.enums.LockServiceType;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author zhuweimu
 * @classname LockTestServiceImpl
 * @description
 * @date 2020/9/21 17:06
 */
@Slf4j
@Service
public class LockTestServiceImpl {

    @Autowired
    RedissonClient redissonClient;

//    @DisLock(prefix = "LockTestServiceImpl",key = "#key",keepTime = 1,lockServiceType = LockServiceType.REDISSON)
    public String getKey(String key){
        try {
            log.info("获取锁成功！！！");
            TimeUnit.SECONDS.sleep(30);
            log.info("执行成功！！");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "锁成功，key = "+key;
    }

}
