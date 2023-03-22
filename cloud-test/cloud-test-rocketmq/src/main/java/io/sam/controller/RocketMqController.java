package io.sam.controller;

import common.BaseResponse;
import io.sam.db.domain.Userinfo;
import io.sam.dto.UserInfoDto;
import lombok.extern.slf4j.Slf4j;
import model.OrderInfo;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.apache.rocketmq.spring.support.RocketMQHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author zhuweimu
 * @description
 * @date 2022/8/1 16:27
 */
@Slf4j
@RestController
@RequestMapping(value = "/rocketmq/")
public class RocketMqController {

    @Autowired
    RocketMQTemplate rocketMQTemplate;

    @GetMapping("send/{msg}")
    public BaseResponse<String> send(@PathVariable String msg){
        log.info("发送消息");
        //发送普通消息
        rocketMQTemplate.convertAndSend("TEST-TOPIC",msg);
        return BaseResponse.success();
    }

    @GetMapping("sendWithTransactional/{id}")
    public BaseResponse<String> sendWithTransactional(@PathVariable Long id){
        log.info("发送事务消息");
        OrderInfo orderInfo = new OrderInfo(id,"Order"+id);
        UserInfoDto userInfoDto = UserInfoDto.builder()
                .id(1001).name("Sam").age(18)
                .build();
        //发送事务消息
        rocketMQTemplate.sendMessageInTransaction("TEST-TRANSACTION-TOPIC",
                MessageBuilder.withPayload(orderInfo)
                        .setHeader(RocketMQHeaders.TRANSACTION_ID, UUID.randomUUID())
                        .build(),
                userInfoDto);
        return BaseResponse.success();
    }

    @GetMapping("sendWithTransactional1/{id}")
    public BaseResponse<String> sendWithTransactional1(@PathVariable Long id){
        log.info("发送事务消息");
        OrderInfo orderInfo = new OrderInfo(id,"Order"+id);
        UserInfoDto userInfoDto = UserInfoDto.builder()
                .id(2001).name("Dean").age(18)
                .build();
        //发送事务消息
        rocketMQTemplate.sendMessageInTransaction("TEST-TRANSACTION-TOPIC-1",
                MessageBuilder.withPayload(orderInfo)
                        .setHeader(RocketMQHeaders.TRANSACTION_ID, UUID.randomUUID())
                        .build(),
                userInfoDto);
        return BaseResponse.success();
    }
}
