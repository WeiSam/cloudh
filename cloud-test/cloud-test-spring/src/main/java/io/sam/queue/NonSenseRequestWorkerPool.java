package io.sam.queue;

import cn.hutool.core.thread.ThreadFactoryBuilder;
import io.sam.config.SysConfig;

import java.util.concurrent.*;

/**
 * @author zhuweimu
 * @description
 * @date 2021/12/15 8:37
 */
public class NonSenseRequestWorkerPool {

    private static ThreadPoolExecutor threadPool = null;

    public NonSenseRequestWorkerPool() {
        RequestQueue requestQueue = RequestQueue.getInstance();
        for(int i = 0; i < threadPool.getCorePoolSize(); i++) {
            ArrayBlockingQueue<NonSenseRequest> queue = new ArrayBlockingQueue<>(2000);
            requestQueue.addQueue(queue);
            threadPool.submit(new NonSenseRequestWorker(queue));
        }
    }

    private static class Singleton {

        private static NonSenseRequestWorkerPool instance;
        static {
            instance = new NonSenseRequestWorkerPool();
        }
        public static NonSenseRequestWorkerPool getInstance() {
            return instance;
        }

    }

    public static NonSenseRequestWorkerPool getInstance() {
        return Singleton.getInstance();
    }

    /**
     * 初始化
     */
    public static void init(SysConfig sysConfig) {
        initTheadPool(sysConfig);
        getInstance();
    }

    private static void initTheadPool(SysConfig sysConfig) {
        threadPool = new ThreadPoolExecutor(2,10,10000, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(100),
                new ThreadFactoryBuilder().setNamePrefix("NonSenseRequestWorkerPool-").build(),
                new ThreadPoolExecutor.DiscardOldestPolicy());
    }
}
