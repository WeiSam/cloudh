package io.sam.config;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author zhuweimu
 * @classname ExecutorConfig
 * @description
 * @date 2020/12/15 20:59
 */
@Slf4j
@Configuration
public class ExecutorConfig {


    @Bean
    public Executor asyncServiceExecutor() {
        log.info("start asyncServiceExecutor");
        // 使用VisiableThreadPoolTaskExecutor
        ThreadPoolTaskExecutor executor = new VisiableThreadPoolTaskExecutor();
        // 配置核心线程数
        executor.setCorePoolSize(5);
        // 配置最大线程数
        executor.setMaxPoolSize(10);
        // 配置队列大小
		executor.setQueueCapacity(5000);
        // 配置线程池中的线程的名称前缀
        executor.setThreadNamePrefix("async-nonsense-service-led");
        // rejection-policy：当pool已经达到max size的时候，如何处理新任务
        // 饱和时拒绝旧任务
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardOldestPolicy());
        // 执行初始化
        executor.initialize();
        return executor;
    }

    @Bean
    public Executor asynComServiceExecutor() {
        log.info("start asynComServiceExecutor");
        // 使用VisiableThreadPoolTaskExecutor
        ThreadPoolTaskExecutor executor = new VisiableThreadPoolTaskExecutor();
        // 配置核心线程数
        executor.setCorePoolSize(5);
        // 配置最大线程数
        executor.setMaxPoolSize(10);
        // 配置队列大小
        executor.setQueueCapacity(5000);
        // 配置线程池中的线程的名称前缀
        executor.setThreadNamePrefix("async-nonsense-service");
        // rejection-policy：当pool已经达到max size的时候，如何处理新任务
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        // 执行初始化
        executor.initialize();
        return executor;
    }

    public class VisiableThreadPoolTaskExecutor extends ThreadPoolTaskExecutor {
        private static final long serialVersionUID = 1L;

        private void showThreadPoolInfo(String prefix) {
            ThreadPoolExecutor threadPoolExecutor = getThreadPoolExecutor();

            if (null == threadPoolExecutor) {
                return;
            }

            log.info("{}, {},taskCount [{}], completedTaskCount [{}], activeCount [{}], queueSize [{}]", this.getThreadNamePrefix(), prefix, threadPoolExecutor.getTaskCount(),
                    threadPoolExecutor.getCompletedTaskCount(), threadPoolExecutor.getActiveCount(), threadPoolExecutor.getQueue().size());
        }

        @Override
        public void execute(Runnable task) {
            showThreadPoolInfo("1. do execute");
            super.execute(task);
        }

        @Override
        public void execute(Runnable task, long startTimeout) {
            showThreadPoolInfo("2. do execute");
            super.execute(task, startTimeout);
        }

        @Override
        public Future<?> submit(Runnable task) {
            showThreadPoolInfo("1. do submit");
            return super.submit(task);
        }

        @Override
        public <T> Future<T> submit(Callable<T> task) {
            showThreadPoolInfo("2. do submit");
            return super.submit(task);
        }

        @Override
        public ListenableFuture<?> submitListenable(Runnable task) {
            showThreadPoolInfo("1. do submitListenable");
            return super.submitListenable(task);
        }

        @Override
        public <T> ListenableFuture<T> submitListenable(Callable<T> task) {
            showThreadPoolInfo("2. do submitListenable");
            return super.submitListenable(task);
        }
    }
}
