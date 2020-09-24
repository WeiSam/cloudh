package io.sam.service.impl;

import io.sam.model.LockResult;
import io.sam.service.LockService;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.TimeUnit;

/**
 * @author zhuweimu
 * @classname CuratorLockServiceImpl
 * @description
 * @date 2020/9/23 19:50
 */
public class CuratorLockServiceImpl implements LockService<InterProcessMutex> {

    private final static String LOCK_BASE_PATH = "/distribute/lock/";

    @Autowired
    CuratorFramework client;

    @Override
    public LockResult<InterProcessMutex> lock(String key, long waitTime, long keepTime, TimeUnit timeUnit) throws Exception{
        LockResult<InterProcessMutex> lockResult = new LockResult();
        InterProcessMutex mutex = new InterProcessMutex(client,LOCK_BASE_PATH+key);
        boolean isSuccess = mutex.acquire((int) waitTime, timeUnit);
        lockResult.setSuccess(isSuccess);
        lockResult.setT(mutex);
        return lockResult;
    }

    @Override
    public void unlock(LockResult<InterProcessMutex> lockResult) throws Exception {
        if (lockResult != null && lockResult.isSuccess() && lockResult.getT() != null) {
            lockResult.getT().release();
        }
    }
}
