package io.sam.config;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author zhuweimu
 * @description
 * @date 2022/1/13 16:21
 */
@Slf4j
@Component
public class ConfirmRabbitTemplate implements RabbitTemplate.ConfirmCallback, RabbitTemplate.ReturnCallback {

    /**
     * rabbitTemplate类型单例的,白设置了当前这个类
     * 参考配置类
     * {@link org.springframework.boot.autoconfigure.amqp.RabbitAutoConfiguration.RabbitTemplateConfiguration}
     */
    @Autowired
    RabbitTemplate rabbitTemplate;

    @PostConstruct
    public void init(){
        //一个rabbitTemplate只能初始化一次
        //设置生产者消息确认
        rabbitTemplate.setConfirmCallback(this);
        //设置交换机路由失败回调函数
        rabbitTemplate.setReturnCallback(this);
    }

    /**
     * 交换机收到消息时回调确认消息
     * @param correlationData 要自己在发消息时设置值才有值
     * @param ack
     * @param cause 确认失败原因
     */
    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        log.info("收到消息确认信息,correlationData = {}", JSON.toJSONString(correlationData));
        if (ack) {
            log.info("EXCHANGE已确认,ack = {}",ack);
        }else {
            log.info("EXCHANGE确认失败");
        }
        log.info("收到消息确认信息结束");
    }

    /**
     * 换机路由队列失败回调,路由失败才触发
     * @param message
     * @param replyCode
     * @param replyText
     * @param exchange
     * @param routingKey
     */
    @Override
    public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
        log.info("交换机路由回调");
    }
}
