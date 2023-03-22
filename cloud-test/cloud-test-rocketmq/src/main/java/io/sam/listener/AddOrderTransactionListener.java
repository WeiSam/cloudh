package io.sam.listener;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionState;
import org.springframework.messaging.Message;

/**
 * @author zhuweimu
 * @description
 * @date 2022/8/2 9:25
 */
@Slf4j
@RocketMQTransactionListener
public class AddOrderTransactionListener implements RocketMQLocalTransactionListener {
    @Override
    public RocketMQLocalTransactionState executeLocalTransaction(Message msg, Object arg) {
        log.info("执行半消息发送成功后业务逻辑,msg = {},arg = {}", JSON.toJSONString(msg),JSON.toJSONString(arg));
        return RocketMQLocalTransactionState.UNKNOWN;
    }

    @Override
    public RocketMQLocalTransactionState checkLocalTransaction(Message msg) {
        log.info("检测事务执行状态,msg = {}",JSON.toJSONString(msg));
        return RocketMQLocalTransactionState.ROLLBACK;
    }
}
