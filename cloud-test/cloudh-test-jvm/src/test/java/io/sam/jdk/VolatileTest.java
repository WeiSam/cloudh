package io.sam.jdk;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;

/**
 * @author zhuweimu
 * @description
 * @date 2021/12/3 14:45
 */
public class VolatileTest {

    /**
     * 添加 volatile 不能保证安全性,只能保证可见性
     */
    private static volatile int count = 0;

    CountDownLatch countDownLatch;
    @Test
    public void test01() throws Exception {
        Integer num = 1000;
        countDownLatch = new CountDownLatch(num);
        for (int i = 0; i < num; i++) {
            Thread thread = new Thread(() -> {
                for (int j = 0; j < 10; j++) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (this.getClass()){
                        count++;
                    }
//                    System.out.println(increasing());
                }
                countDownLatch.countDown();
            });
            thread.start();
        }
        countDownLatch.await();
        System.out.println("count = "+count);
    }

    private synchronized int increasing() {

        return ++count;
    }
}
