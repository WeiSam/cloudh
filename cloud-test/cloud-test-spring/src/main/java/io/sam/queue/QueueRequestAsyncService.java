package io.sam.queue;

/**
 * @author zhuweimu
 * @description
 * @date 2021/12/14 20:23
 */
public interface QueueRequestAsyncService {

    /**
     * 执行请求
     * @param nonSenseRequest
     */
    void process(NonSenseRequest nonSenseRequest);
}
