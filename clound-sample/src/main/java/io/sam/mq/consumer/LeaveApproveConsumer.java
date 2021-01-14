package io.sam.mq.consumer;

import com.alibaba.fastjson.JSON;
import io.sam.constant.MQContants;
import io.sam.dto.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

/**
 * @author zhuweimu
 * @classname LeaveApproveConsumer
 * @description
 * @date 2020/9/29 9:46
 */
@Slf4j
@Component
public class LeaveApproveConsumer {

    @RabbitListener(bindings = @QueueBinding(value = @Queue(value = MQContants.LEAVE_APPROVE_QUEUE,durable = "false"),
            exchange = @Exchange(value = MQContants.LEAVE_APPROVE_EXCHANGE, type = ExchangeTypes.TOPIC),
            key = MQContants.LEAVE_APPROVE_KEY))
    public void receiveMessage(@Payload UserDto userDto){
        log.info("01接收消息，userDto = {}", JSON.toJSONString(userDto));
    }

    @RabbitListener(bindings = @QueueBinding(value = @Queue(value = MQContants.LEAVE_APPROVE_QUEUE,durable = "false"),
            exchange = @Exchange(value = MQContants.LEAVE_APPROVE_EXCHANGE, type = ExchangeTypes.TOPIC),
            key = MQContants.LEAVE_APPROVE_KEY))
    public void receiveMessage02(@Payload UserDto userDto){
        log.info("02接收消息，userDto = {}", JSON.toJSONString(userDto));
    }
}
