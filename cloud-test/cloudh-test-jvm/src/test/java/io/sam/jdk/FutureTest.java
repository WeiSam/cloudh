package io.sam.jdk;

import cn.hutool.core.thread.ThreadFactoryBuilder;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author zhuweimu
 * @description jdk异步回调编程
 * 示例:
 * 假如我们需要出去旅游，需要完成三个任务：
 *
 * 任务一：订购航班
 * 任务二：订购酒店
 * 任务三：订购租车服务
 * 很显然任务一和任务二没有相关性，可以单独执行。但是任务三必须等待任务一与任务二结束之后，才能订购租车服务。
 *
 * 使用Future和CompletableFuture比较
 *
 *
 * @date 2021/8/4 10:28
 */
@Slf4j
public class FutureTest {

    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10,10,10000, TimeUnit.SECONDS,
            new LinkedBlockingDeque<>(100),
            new ThreadFactoryBuilder().setNamePrefix("FutureTest-").build(),
            new ThreadPoolExecutor.AbortPolicy());

    /**
     * Future 调用get()方法时才执行线程
     * @throws Exception
     */
    @Test
    public void testFuture() throws Exception {
        CountDownLatch countDownLatch = new CountDownLatch(2);
        Future<Object> task1 = threadPoolExecutor.submit(new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                Object bookFlight = bookFlight();
                countDownLatch.countDown();
                return bookFlight;
            }
        });

        Future<Object> task2 = threadPoolExecutor.submit(new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                Object bookHotel = bookHotel();
                countDownLatch.countDown();
                return bookHotel;
            }
        });
        countDownLatch.await();
        //
        log.info("准备完成,航班号:{},酒店位置:{}",task1.get(),task2.get());

        Future<Object> task3 = threadPoolExecutor.submit(new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                return callTaxi();
            }
        });

        log.info("打的出发,车牌号:{}",task3.get());
    }

    @Test
    public void testCompletableFuture() throws InterruptedException {
        //创建异步实例
        CompletableFuture<Object> task1 = CompletableFuture.supplyAsync(FutureTest::bookFlight,threadPoolExecutor);
        CompletableFuture<Object> task2 = CompletableFuture.supplyAsync(FutureTest.this::bookHotel,threadPoolExecutor);
//        Thread.sleep(10000);
        //创建同步执行
        CompletableFuture<String> task3 = task2.thenCombine(task1, FutureTest.this::callTaxi2);
        String task3Result = task3.join();
        log.info("打的出发,车牌号:{}",task3Result);
    }

    private String callTaxi2(Object plane, Object hotel) {
        log.info("准备完成,航班号:{},酒店位置:{},打的开始",plane,hotel);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("打的完成");
        return "粤Afjskhfj";
    }

    private Object callTaxi() {
        log.info("打的开始");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("打的完成");
        return "粤Afjskhfj";
    }


    private Object bookHotel() {
        log.info("订购酒店开始");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("订购酒店完成");
        return "1234";
    }

    private static Object bookFlight() {
        log.info("订购航班开始");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("订购航班完成");
        return "12879738878274";
    }

    @Test
    public void testOrder() {
        List<String> tasks = new ArrayList<>();
        tasks.add("任务1");
        tasks.add("任务2");
        tasks.add("任务3");
        List<CompletableFuture<String>> futures = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            int finalI = i;
            CompletableFuture<String> voidCompletableFuture = CompletableFuture
                    .runAsync(() -> {
                        log.info("[{}]开始执行任务1", finalI);
                        try {
                            TimeUnit.SECONDS.sleep(5);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        if (finalI == 0) {
                            int ii = 100/0;
                        }
                        log.info("[{}]结束任务1",finalI);
                    }, threadPoolExecutor)
                    .thenAccept(aVoid -> {
                        log.info("[{}]开始执行任务2", finalI);
                        try {
                            TimeUnit.SECONDS.sleep(2);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        log.info("[{}]结束任务2",finalI);
                    })
                    .thenCompose(aVoid -> CompletableFuture.supplyAsync(() -> {
                        log.info("[{}]开始执行任务3", finalI);
                        try {
                            TimeUnit.SECONDS.sleep(2);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        log.info("[{}]结束任务3",finalI);
                        return "任务全部结束"+finalI;
                    })).whenCompleteAsync((s, throwable) -> {
                        log.error("[{}]发生异常:{}",finalI,s,throwable);
                    },threadPoolExecutor);
            futures.add(voidCompletableFuture);
        }
        log.info("主线程执行");
        log.info("主线程执行");
        futures.forEach(task -> System.out.println(task.join()));
        log.info("主线程执行结束");
    }

    @Test
    public void testOrder2() {

        CompletableFuture.supplyAsync(() -> {
            log.info("我媳妇儿正在炒菜");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "红烧排骨、清蒸鲈鱼";
        }).thenCompose(dish -> CompletableFuture.supplyAsync(() -> {  //接着上一个任务结束之后，开启一个异步任务
            log.info("媳妇儿通知我吃她做好的菜："+dish);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }));

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
