package io.sam.mq.consumer;

import com.alibaba.fastjson.JSON;
import com.rabbitmq.client.Channel;
import io.sam.constant.MQContants;
import io.sam.dto.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;

/**
 * @author zhuweimu
 * @classname LeaveApproveConsumer
 * @description
 * @date 2020/9/29 9:46
 */
@Slf4j
@Component
public class LeaveApproveConsumer {

    private final HashMap<String, Integer> map = new HashMap<>();

/*    @RabbitListener(bindings = @QueueBinding(value = @Queue(value = MQContants.LEAVE_APPROVE_QUEUE,durable = "false"),
            exchange = @Exchange(value = MQContants.LEAVE_APPROVE_EXCHANGE, type = ExchangeTypes.TOPIC),
            key = MQContants.LEAVE_APPROVE))
    public void receiveMessage(@Payload UserDto userDto,Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) long tag) throws Exception {
        log.info("01接收消息，Number = {},userDto = {},tag = {}", channel.getChannelNumber(),userDto.getName(),tag);
        channel.basicAck(tag,false);
//        channel.basicQos(2);
        log.info("01接收消息结束");
    }*/

/*    @RabbitListener(bindings = @QueueBinding(value = @Queue(value = MQContants.LEAVE_APPROVE_QUEUE02,durable = "false"),
            exchange = @Exchange(value = MQContants.LEAVE_APPROVE_EXCHANGE, type = ExchangeTypes.TOPIC),
            key = MQContants.LEAVE_APPROVE))
    public void receiveMessage02(@Payload UserDto userDto, Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) long tag){
        log.info("02接收消息，userDto = {}", channel.getChannelNumber());
        try {
            //true:重新放回队列中
//            channel.basicReject(tag,false);
            // multiple:全应答表示
            // true:全应答,即当一个channel中一个tag被应答,其中所有的tag都被标识应答,不建议设置,一个channel可能会绑定多个消费者
            //false:只是当前tag标识为应答
            channel.basicAck(tag,false);
        } catch (IOException e) {
            log.error("发生异常",e);

        }
    }*/

    /**
     * 死信队列
     * @param message
     * @param channel
     * @param tag
     * @throws Exception
     */
    @RabbitListener(bindings = @QueueBinding(value = @Queue(value = MQContants.LEAVE_LETTER_QUEUE,durable = "true"),
            exchange = @Exchange(value = MQContants.LEAVE_LETTER_EXCHANGE, type = ExchangeTypes.TOPIC),
            key = MQContants.LEAVE_LETTER_KEY))
    public void deadLetter(Message message, Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) long tag) throws Exception {
        log.info("deadLetter接收消息，Number = {},tag = {}", channel.getChannelNumber(),tag);
        channel.basicAck(tag,false);
        log.info("deadLetter接收消息接收消息结束");
    }

    @RabbitListener(bindings = @QueueBinding(value = @Queue(value = MQContants.LEAVE_APPROVE_QUEUE03,
            arguments = {@Argument(name = "x-dead-letter-exchange",value = MQContants.LEAVE_LETTER_EXCHANGE),
            @Argument(name = "x-dead-letter-routing-key",value = MQContants.LEAVE_LETTER_KEY)}
            ,durable = "false"),
            exchange = @Exchange(value = MQContants.LEAVE_APPROVE_EXCHANGE, type = ExchangeTypes.TOPIC),
            key = MQContants.LEAVE_APPROVE))
    public void receiveMessage03(@Payload UserDto userDto,Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) long tag) throws Exception {
        boolean isAck = true;
        Integer count = 0;
        try {
            log.info("03接收消息，Number = {},userDto = {},tag = {}", channel.getChannelNumber(),userDto.getName(),tag);
            boolean b = "test0".equals(userDto.getName());
            if(b){
                throw new Exception("测试异常");
            }
        } catch (Exception e) {
            isAck = false;
            count = map.computeIfAbsent(userDto.getName(),s -> 0);
            map.put(userDto.getName(),++count);
            log.error("异常不应答:{}",tag,e);
        } finally {
            if (isAck) {
                channel.basicAck(tag,false);
                log.info("应答:{}",tag);
            }else {
                //requeue:是否重新放入队列 true:逻辑处理异常时需重新消费可设置,异常会一直调用消费,慎用
                channel.basicNack(tag,false, count <= 10);
                if (count > 10) {
                    map.remove(userDto.getName());
                }
                log.info("异常不应答:{}",tag);
            }
        }
    }

}
