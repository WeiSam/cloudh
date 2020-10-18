package io.sam.mq.producer;

import io.sam.constant.MQContants;
import io.sam.dto.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author zhuweimu
 * @classname LeaveA
 * @description
 * @date 2020/9/29 9:07
 */
@Slf4j
@Component
public class LeaveApproveProducer {

    @Autowired
    RabbitTemplate rabbitTemplate;

    public void send(UserDto userDto){
        rabbitTemplate.convertAndSend(MQContants.LEAVE_APPROVE_EXCHANGE,MQContants.LEAVE_APPROVE_KEY,userDto);
        log.info("成功发送消息");
    }
}
