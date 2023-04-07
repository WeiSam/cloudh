package io.sam.jdk;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
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

    public static final ReentrantLock lock = new ReentrantLock();

    Condition emptyLock = lock.newCondition();
    Condition notEmptyLock = lock.newCondition();
    Condition stopLock = lock.newCondition();

    public static volatile boolean isEmpty = false;
    public static volatile Integer count = 0;

    @Test
    public void testAwith() throws InterruptedException {

        log.info("{}",Thread.currentThread().getState().toString());
        notEmptyLock.await();

        lock.lock();
        try {
            new Thread(() -> {
                lock.lock();
                try {
                    while (count < 10){
                        if (isEmpty) {
                            notEmptyLock.await();
                        }
                        log.info("消费,count = {}",count);
                        TimeUnit.SECONDS.sleep(1);
                        isEmpty = true;
                        emptyLock.signal();
                    }
                    stopLock.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
            }).start();
            new Thread(() -> {
                lock.lock();
                try {
                    while (count < 10){
                        if (!isEmpty) {
                            emptyLock.await();
                        }
                        TimeUnit.SECONDS.sleep(1);
                        count++;
                        isEmpty = false;
                        log.info("生成:count = {}",count);
                        notEmptyLock.signal();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
            }).start();
            log.info("开始等待");
            stopLock.await();
            log.info("执行结束");
        }catch (Exception e){
            log.error("",e);
        }finally {
            lock.unlock();
        }

    }

    @Test
    public void testSyn() throws Exception {
        CountDownLatch countDownLatch = new CountDownLatch(20000);
        Map<Integer,String> map = new HashMap<>();
        for (int i = 1; i < 100; i++) {
            map.put(i,String.valueOf(i));
        }

        for (int j = 0; j < 10000; j++) {
            String key1 = new String("123");
            new Thread(() -> {
                for (int i = 1; i <= 10; i++) {
                    String key = map.get(i);
//                    log.info("key:{}",key.hashCode());
                    synchronized (key1.intern()){
                        count1++;
                    }
                }
                countDownLatch.countDown();
            }).start();

            new Thread(() -> {
                for (int i = 1; i <= 10; i++) {
                    String key = map.get(2);
//                    log.info("key:{}",key.hashCode());
                    synchronized (key){
                        count2++;
                    }
                }
                countDownLatch.countDown();
            }).start();
        }

        countDownLatch.await();
        log.info("count1 = {},count2 = {}",count1,count2);
        log.info("{}",count1==count2);
    }

    @Test
    public void test01() throws InterruptedException {

        Date date1 = new Date();
        Thread.sleep(1000);
        Date date2 = new Date();
        System.out.println(date2.after(date1));

    }

    @Test
    public void testIntern() {
        //先从字符串常量池中找
        String str1 = "java001";
        String str2 = "java001";
        //在堆中创建字符串
        String str3 = new String("java001");
        log.info("{}",str1 == str2);
        log.info("{}",str1 == str3);
        //调用intern(),先从常量池中找,存在则返回字符串的引用,不存在则创建一个引用对象,引用地址为堆中的字符串地址
        log.info("{}",str1.intern() == str3);
        log.info("{}",str1 == str3.intern());
    }

    @Test
    public void test05() throws InterruptedException {
        new Thread(() -> {
            lock.lock();
            try {
                System.out.println("获取锁");
                TimeUnit.SECONDS.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        Thread.sleep(1000);
        lock.lock();
//        System.out.println(lock.tryLock());
        lock.unlock();
    }
}
