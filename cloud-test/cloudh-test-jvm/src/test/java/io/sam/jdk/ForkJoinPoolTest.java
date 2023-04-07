package io.sam.jdk;

import io.sam.service.AddRecursiveTask;
import io.sam.service.LogRecursiveAction;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.TimeUnit;

/**
 * @author zhuweimu
 * @description
 * @date 2023/4/6 10:12
 */
@Slf4j
public class ForkJoinPoolTest {

    @Test
    public void testRe() throws Exception {
        log.info("任务执行开始");
        int min = 0;
        int max = 10000;
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        //提交任务
//        Integer total = forkJoinPool.invoke(new AddRecursiveTask(min, max));
        Integer total = forkJoinPool.submit(new AddRecursiveTask(min, max)).get();
        //等待任务执行完毕
        forkJoinPool.shutdown();
        log.info("累加应当总和:{},累加总和：{}",((min+max)*(max-min+1)/2),total);
        log.info("任务执行结束");
    }

    @Test
    public void testNotRe() throws InterruptedException {
        log.info("任务执行开始");
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        //提交任务
        forkJoinPool.execute(new LogRecursiveAction(0,1000));
        //等待任务执行完毕
        forkJoinPool.awaitTermination(5, TimeUnit.SECONDS);
        forkJoinPool.shutdown();
        log.info("任务执行结束");
    }
}
