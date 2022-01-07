package io.sam.mq.consumer;

import com.alibaba.fastjson.JSON;
import com.rabbitmq.client.Channel;
import io.sam.constant.MQContants;
import io.sam.dto.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.IOException;

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
            key = MQContants.LEAVE_APPROVE))
    public void receiveMessage(@Payload UserDto userDto) throws Exception {
        log.info("01接收消息，userDto = {}", JSON.toJSONString(userDto));
        log.info("01接收消息结束");

    }

    @RabbitListener(bindings = @QueueBinding(value = @Queue(value = MQContants.LEAVE_APPROVE_QUEUE02,durable = "false"),
            exchange = @Exchange(value = MQContants.LEAVE_APPROVE_EXCHANGE, type = ExchangeTypes.TOPIC),
            key = MQContants.LEAVE_APPROVE))
    public void receiveMessage02(@Payload UserDto userDto, Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) long tag){
        log.info("02接收消息，userDto = {}", JSON.toJSONString(userDto));
        try {
            //true:重新放回队列中
            channel.basicReject(tag,false);
        } catch (IOException e) {
            log.error("发生异常",e);
        }
    }

    @RabbitListener(bindings = @QueueBinding(value = @Queue(value = MQContants.LEAVE_APPROVE_QUEUE03,durable = "false"),
            exchange = @Exchange(value = MQContants.LEAVE_APPROVE_EXCHANGE, type = ExchangeTypes.TOPIC),
            key = MQContants.LEAVE_APPROVE))
    public void receiveMessage03(@Payload UserDto userDto) throws Exception {
        log.info("03接收消息，userDto = {}", JSON.toJSONString(userDto));
        if(1==1){
            throw new Exception("测试异常");
        }
    }
}
