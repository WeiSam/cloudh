package io.sam.event;

import io.sam.dto.UserDto;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

/**
 * @author zhuweimu
 * @classname TestInfoEvent
 * @description
 * @date 2020/10/26 16:35
 */
@Getter
public class TestInfoEvent extends ApplicationEvent {

    private UserDto userDto;

    public TestInfoEvent(UserDto userDto) {
        super(userDto);
        this.userDto = userDto;
    }
}
