package io.sam.queue.impl;

import io.sam.queue.NonSenseRequest;
import io.sam.queue.QueueRequestAsyncService;
import io.sam.queue.RequestQueue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author zhuweimu
 * @description
 * @date 2021/12/14 20:23
 */
@Service
public class QueueRequestAsyncServiceImpl implements QueueRequestAsyncService {

    Logger logger = LoggerFactory.getLogger(QueueRequestAsyncServiceImpl.class);

    @Override
    public void process(NonSenseRequest nonSenseRequest) {
        try {
            //获取人员magicid
            String personMagicId = nonSenseRequest.getPersonMagicId();
            if (StringUtils.isEmpty(personMagicId)) {
                logger.error("[无感定位匹配消息]用户id不能为空，过滤");
                return;
            }
            ArrayBlockingQueue<NonSenseRequest> queue = getRoutingQueue(personMagicId);
            // 将请求放入对应的队列中，完成路由操作
            queue.put(nonSenseRequest);
        } catch (InterruptedException e) {
            logger.error("[无感定位匹配消息]人员定位处理发生异常",e);
        }
    }


    /**
     * 获取路由到的内存队列
     * @param personMagicId
     * @return
     */
    private ArrayBlockingQueue<NonSenseRequest> getRoutingQueue(String personMagicId) {
        RequestQueue requestQueue = RequestQueue.getInstance();

        // 先获取productId的hash值
        int hash = personMagicId.hashCode() ^ (personMagicId.hashCode() >>> 16);
        // 对hash值取模，将hash值路由到指定的内存队列中,
        // 队列大小最好设置为2的幂次方,增加散列度
        int index = (requestQueue.queueSize() - 1) & hash;
        return requestQueue.getQueue(index);
    }
}
