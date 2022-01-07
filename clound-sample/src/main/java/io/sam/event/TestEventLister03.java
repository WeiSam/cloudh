package io.sam.event;

import com.alibaba.fastjson.JSON;
import io.sam.dto.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

/**
 * @author zhuweimu
 * @classname TestEventLister
 * @description 事件监听 发布事件时存在事务才生效
 * @date 2020/10/26 16:41
 */
@Slf4j
//@Component
public class TestEventLister03 {

    @TransactionalEventListener
    public void process(TestInfoEvent event) {
        UserDto source = (UserDto)event.getSource();
        UserDto userDto = event.getUserDto();
        log.info("TestEventLister03,source = {}", JSON.toJSONString(source));
        log.info("TestEventLister03,userDto = {}", JSON.toJSONString(userDto));
    }
}
