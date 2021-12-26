package io.sam.controller;

import io.sam.dto.UserDto;
import io.sam.mq.producer.LeaveApproveProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhuweimu
 * @description
 * @date 2021/6/30 16:32
 */
@Slf4j
@RestController
@RequestMapping("mq")
public class MqController {

    @Autowired
    LeaveApproveProducer leaveApproveProducer;

    @GetMapping("/send/{name}")
    public String sendMq(@PathVariable("name") String name){
        leaveApproveProducer.send(new UserDto().setName(name).setAge(18));
        return "成功";
    }
}
