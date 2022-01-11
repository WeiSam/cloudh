package io.sam.event;

import com.alibaba.fastjson.JSON;
import io.sam.dto.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @author zhuweimu
 * @classname TestEventLister
 * @description
 * @date 2020/10/26 16:41
 */
@Slf4j
@Component
public class TestEventLister02 {

    @Async
    @EventListener
    public void process(TestInfoEvent event) {
        UserDto source = (UserDto)event.getSource();
        UserDto userDto = event.getUserDto();
        log.info("TestEventLister02,source = {}", JSON.toJSONString(source));
    }
}
