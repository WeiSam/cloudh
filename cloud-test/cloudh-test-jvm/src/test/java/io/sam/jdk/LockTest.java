package io.sam.jdk;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zhuweimu
 * @description
 * @date 2021/12/14 13:50
 */
@Slf4j
public class LockTest {

    private static int count1 = 0;
    private static int count2 = 0;

    private static Lock lock = new ReentrantLock();

    @Test
    public void testSyn() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(200);
        Map<Integer,String> map = new HashMap<>();
        for (int i = 1; i < 100; i++) {
            map.put(i,String.valueOf(i));
        }

        for (int j = 0; j < 100; j++) {
            new Thread(() -> {
                for (int i = 1; i <= 100; i++) {
                    String key = map.get(1);
                    log.info("key:{}",key.hashCode());
                    synchronized (key){
                        count1++;
                    }
                }
                countDownLatch.countDown();
            }).start();

            new Thread(() -> {
                for (int i = 1; i <= 100; i++) {
                    String key = map.get(2);
                    log.info("key:{}",key.hashCode());
                    synchronized (key){
                        count2++;
                    }
                }
                countDownLatch.countDown();
            }).start();
        }

        countDownLatch.await();
        log.info("count1 = {},count2 = {}",count1,count2);
    }

    @Test
    public void test01() throws InterruptedException {

        Date date1 = new Date();
        Thread.sleep(1000);
        Date date2 = new Date();
        System.out.println(date2.after(date1));

    }

    @Test
    public void testLock01() throws InterruptedException {
        lock.lock();
        log.info("加锁成功");
        TimeUnit.SECONDS.sleep(1000);
        lock.unlock();
        log.info("释放锁");
    }
}
