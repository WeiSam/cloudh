package io.sam.service.impl;

import io.sam.model.LockResult;
import io.sam.service.LockService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author zhuweimu
 * @description
 * @date 2021/7/16 14:32
 */
@Slf4j
@Service("FAKE_LOCK_SERVICE")
public class FakeLockServiceImpl implements LockService<Object> {
    /**
     * @param key
     * @param waitTime
     * @param keepTime
     * @param timeUnit
     * @return
     */
    @Override
    public LockResult<Object> lock(String key, long waitTime, long keepTime, TimeUnit timeUnit) throws Exception {
        log.info("假上锁成功");
        LockResult<Object> result = new LockResult<>();
        result.setSuccess(true);
        return result;
    }

    /**
     * @param lockResult
     */
    @Override
    public void unlock(LockResult<Object> lockResult) throws Exception {
        log.info("假释放锁成功");
    }
}
