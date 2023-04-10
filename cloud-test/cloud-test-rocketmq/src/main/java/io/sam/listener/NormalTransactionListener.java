package io.sam.listener;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;

/**
 * @author zhuweimu
 * @desc
 * @date 2023/3/22 22:24
 */
@Slf4j
@RocketMQMessageListener(topic = "TEST-TOPIC",consumerGroup = "")
public class NormalTransactionListener implements RocketMQListener<String> {

    @Override
    public void onMessage(String message) {
        
    }
}
