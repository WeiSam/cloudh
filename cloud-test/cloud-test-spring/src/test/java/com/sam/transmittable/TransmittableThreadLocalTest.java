package com.sam.transmittable;

import com.alibaba.ttl.TransmittableThreadLocal;
import io.sam.bean.UserBean;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author zhuweimu
 * @description
 * @date 2022/7/28 15:16
 */
@Slf4j
public class TransmittableThreadLocalTest {

    public static TransmittableThreadLocal<UserBean> MAP = new TransmittableThreadLocal<>();
    public static ThreadLocal<UserBean> LOCAL_MAP = new ThreadLocal<>();

    ExecutorService executor = Executors.newFixedThreadPool(10);

    @Test
    void testThreadLocal() throws InterruptedException {
        for (int i = 1; i < 2; i++) {
            int finalI = i;
            Thread thread = new Thread(() -> {
                /**
                 * ThreadLocal中父线程设置值后，线程池线程获取不到父线程设置的值，
                 * 父子线程共享变量传递会有问题
                 */
                LOCAL_MAP.set(new UserBean()
                        .setId(String.valueOf(finalI))
                        .setName("Sam" + finalI));
                new Thread(() -> {
                    log.info("子线程:{},获取用户信息:{}", Thread.currentThread().getName(), LOCAL_MAP.get());
                }).start();
                executor.submit(() -> {
                    log.info("当前线程:{},获取用户信息:{}", Thread.currentThread().getName(), LOCAL_MAP.get());
                });
                log.info("当前线程:{},获取用户信息:{}", Thread.currentThread().getName(), LOCAL_MAP.get());
            });
            thread.start();
            thread.join();
        }
    }

    @Test
    void testTransmittableThreadLocal() throws InterruptedException {
        for (int i = 1; i < 3; i++) {
            int finalI = i;
            Thread thread = new Thread(() -> {
                /**
                 * ThreadLocal中父线程设置值后，线程池子线程获取不到父线程设置的值，
                 * 父子线程共享变量传递会有问题,
                 * 故可使用TransmittableThreadLocal
                 * 更多用法参考{https://github.com/alibaba/transmittable-thread-local}
                 */
                MAP.set(new UserBean()
                        .setId(String.valueOf(finalI))
                        .setName("Sam" + finalI));
                new Thread(() -> {
                    log.info("子线程:{},获取用户信息:{}", Thread.currentThread().getName(), MAP.get());
                }).start();
                executor.submit(() -> {
                    log.info("当前线程:{},获取用户信息:{}", Thread.currentThread().getName(), MAP.get());
                });
                log.info("当前线程:{},获取用户信息:{}", Thread.currentThread().getName(), MAP.get());
            });
            thread.start();
            thread.join();
        }
    }
}
