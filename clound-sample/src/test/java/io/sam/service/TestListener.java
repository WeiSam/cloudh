package io.sam.service;

import io.sam.BaseTest;
import io.sam.dto.UserDto;
import io.sam.event.TestInfoEvent;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEventPublisher;

/**
 * @author zhuweimu
 * @classname TestListener
 * @description
 * @date 2020/10/26 16:44
 */
public class TestListener extends BaseTest {

    @Autowired
    ApplicationContext applicationContext;

    @Autowired
    ApplicationEventPublisher eventPublisher;

    @Test
    public void testEvent() throws InterruptedException {
        for (int i = 0;i<10;i++){
            UserDto userDto = new UserDto();
            userDto.setName("sam").setAge(12);
            applicationContext.publishEvent(new TestInfoEvent(userDto));
        }
        Thread.sleep(1000);
    }
}
