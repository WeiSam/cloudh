package io.sam.queue;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author zhuweimu
 * @description
 * @date 2021/12/14 17:56
 */
public class RequestQueue {

    /**
     * 内存队列
     */
    private List<ArrayBlockingQueue<NonSenseRequest>> queues = new ArrayList<ArrayBlockingQueue<NonSenseRequest>>();

    private static class Singleton {

        private static RequestQueue instance;

        static {
            instance = new RequestQueue();
        }

        public static RequestQueue getInstance() {
            return instance;
        }

    }

    public static RequestQueue getInstance() {
        return Singleton.getInstance();
    }

    /**
     * 添加一个内存队列
     * @param queue
     */
    public void addQueue(ArrayBlockingQueue<NonSenseRequest> queue) {
        this.queues.add(queue);
    }

    /**
     * 获取内存队列的数量
     * @return
     */
    public int queueSize() {
        return queues.size();
    }

    /**
     * 获取内存队列
     * @param index
     * @return
     */
    public ArrayBlockingQueue<NonSenseRequest> getQueue(int index) {
        return queues.get(index);
    }
}
