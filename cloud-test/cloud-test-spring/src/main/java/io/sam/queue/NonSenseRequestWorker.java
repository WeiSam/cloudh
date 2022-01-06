package io.sam.queue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;

/**
 * @author zhuweimu
 * @description
 * @date 2021/12/14 20:49
 */
public class NonSenseRequestWorker implements Callable<Boolean> {

    Logger logger = LoggerFactory.getLogger(NonSenseRequestWorker.class);
    /**
     * 自己监控的内存队列
     */
    private ArrayBlockingQueue<NonSenseRequest> queue;

    private NonSenseRequestWorker() {
    }

    public NonSenseRequestWorker(ArrayBlockingQueue<NonSenseRequest> queue) {
        this.queue = queue;
    }

    @Override
    public Boolean call(){
        while(true) {
            try {
                // ArrayBlockingQueue
                // Blocking就是说明，如果队列满了，或者是空的，那么都会在执行操作的时候，阻塞住
                NonSenseRequest request = queue.take();
                logger.info("队列消费获取信息");
                // 执行这个request操作
                request.process();
                logger.info("队列消费结束");
            }catch (InterruptedException e){
                logger.error("异常中断",e);
            }catch (Exception e){
                logger.error("消费无感定位人员匹配数据异常",e);
            }
        }
    }
}
