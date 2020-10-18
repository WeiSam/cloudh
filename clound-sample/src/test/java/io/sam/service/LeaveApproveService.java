package io.sam.service;

import io.sam.BaseTest;
import io.sam.dto.UserDto;
import io.sam.mq.producer.LeaveApproveProducer;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author zhuweimu
 * @classname LeaveApproveService
 * @description
 * @date 2020/9/29 10:07
 */
public class LeaveApproveService extends BaseTest {

    @Autowired
    LeaveApproveProducer leaveApproveProducer;

    @Test
    public void testRabbitMq() throws InterruptedException {
        leaveApproveProducer.send(new UserDto().setName("sam").setAge(18));
        Thread.sleep(1000*10);
    }
}
