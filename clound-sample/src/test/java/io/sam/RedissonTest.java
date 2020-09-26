package io.sam;

import org.junit.Test;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author zhuweimu
 * @classname RedissonTest
 * @description
 * @date 2020/9/21 10:34
 */
public class RedissonTest extends BaseTest{

    @Autowired
    RedissonClient redissonClient;

    @Test
    public void testRedisson() throws InterruptedException {
        RLock lock = redissonClient.getLock("testRedisson");
        lock.lock();
        Thread.sleep(100);
        lock.unlock();
    }
}
