package io.sam.event;

import com.alibaba.fastjson.JSON;
import io.sam.dto.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author zhuweimu
 * @classname TestEventLister
 * @description spring事件监听
Spring 提供了以下 种标准的事件
(1) 上下文更新事件(ontextRefreshedEvent)该事件会在 pplica ionContext 被初始化或
者更新时发布。 也可以在调用 ConfigurAbleApplicationContetxt 接口中的 refres() 方法时被触发。
(2) 上下文开始事件( ContextStartedEvent )：当容器调用 ConfigurableApplicationContext的
Start（） 方法开始或重新开始容器时触发该事件。
(3)上下文停止事件( ContextStoppedEvent )：当容器调用 ConfigurableApplicationContext的
Stop()方法停止容器时触发该事件。
(4)上下文关闭事件( ContextclosedEvent) 被关闭时触发该事件。容器被关闭时，其管理的所有单例 Bean 都被销毁。
(5) 请求处理事件( RequestHandleEvent) 在Web应用中，当一个HTTP请求（ Request)结束时触发该事件。
 * @date 2020/10/26 16:41
 */
@Slf4j
@Component
public class TestEventLister01 implements ApplicationListener<TestInfoEvent> {

    @Override
    public void onApplicationEvent(TestInfoEvent event) {
        UserDto source = (UserDto)event.getSource();
        UserDto userDto = event.getUserDto();
        log.info("source = {}", JSON.toJSONString(source));
        log.info("userDto = {}", JSON.toJSONString(userDto));
    }
}
