package io.sam.service.impl;

import io.sam.model.LockResult;
import io.sam.service.LockService;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author zhuweimu
 * @classname RedissonLockService
 * @description
 * @date 2020/9/21 14:49
 */
@ConditionalOnBean(RedissonClient.class)
@Component("REDISSON_LOCK")
public class RedissonLockService implements LockService<RLock> {

    Logger log = LoggerFactory.getLogger(RedissonLockService.class);

    @Autowired
    RedissonClient redissonClient;

    @Override
    public LockResult<RLock> lock(String key, long waitTime, long keepTime, TimeUnit timeUnit) {
        RLock lock = redissonClient.getLock(key);
        LockResult<RLock> lockResult = new LockResult();
        try {
            lockResult.setSuccess( lock.tryLock(waitTime, keepTime, timeUnit));
            lockResult.setT(lock);
        } catch (InterruptedException e) {
            log.error("加锁出现异常，msg = {}",e.getMessage(),e);
            lockResult.setSuccess(false);
        }
        return lockResult;
    }

    @Override
    public void unlock(LockResult<RLock> lockResult) {
        if (lockResult != null && lockResult.getT() != null && lockResult.isSuccess()) {
            lockResult.getT().unlock();
        }
    }
}
