package io.sam.service;

import io.sam.model.LockResult;

import java.util.concurrent.TimeUnit;

/**
 * @author zhuweimu
 * @classname LockService
 * @description
 * @date 2020/9/21 14:48
 */
public interface LockService<T> {

    /**
     *
     * @param key
     * @param waitTime
     * @param keepTime
     * @param timeUnit
     * @return
     */
    LockResult<T> lock(String key, long waitTime, long keepTime, TimeUnit timeUnit) throws Exception;

    /**
     *
     * @param lockResult
     */
    void unlock(LockResult<T> lockResult) throws Exception;
}
