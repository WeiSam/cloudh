package io.sam.mq.producer;

import io.sam.constant.MQContants;
import io.sam.dto.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Component;

/**
 * @author zhuweimu
 * @classname LeaveA
 * @description
 * @date 2020/9/29 9:07
 */
@Slf4j
@Component
public class LeaveApproveProducer implements InitializingBean {

    @Autowired
    RabbitTemplate rabbitTemplate;

    RabbitTemplate deferRabbitTemplate = new RabbitTemplate();

    public void send(UserDto userDto){
        deferRabbitTemplate.convertAndSend(MQContants.LEAVE_APPROVE_EXCHANGE,MQContants.LEAVE_APPROVE,userDto);
        log.info("成功发送消息");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        BeanCopier.create(RabbitTemplate.class,RabbitTemplate.class,false)
                .copy(rabbitTemplate,deferRabbitTemplate,null);
        //设置消息到达EXCHANGE时回调 需配置publisher-confirm-type: correlated
        deferRabbitTemplate.setConfirmCallback(new RabbitTemplate.ConfirmCallback() {
            @Override
            public void confirm(CorrelationData correlationData, boolean ack, String cause) {
                if (ack) {
                    log.info("EXCHANGE已确认,ack = {}",ack);
                }else {
                    log.info("EXCHANGE确认失败");
                }

            }
        });
        rabbitTemplate.setReturnCallback((message, replyCode, replyText, exchange, routingKey) -> {

        });
    }
}
