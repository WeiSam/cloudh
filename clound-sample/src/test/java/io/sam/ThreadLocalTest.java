package io.sam;

import io.sam.dto.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author zhuweimu
 * @Classname ThreadLocalTest
 * @Description
 * @date 2020/9/4 19:45
 */
@Slf4j
public class ThreadLocalTest {

    ThreadLocal<UserDto> threadLocal = new ThreadLocal<UserDto>(){
        protected UserDto initialValue() {
            return new UserDto().setName("threadLocal");
        }
    };

    ThreadLocal<UserDto> threadLocal1 = new ThreadLocal<UserDto>(){
        protected UserDto initialValue() {
            return new UserDto().setName("threadLocal1");
        }
    };

    @Test
    public void test01() throws InterruptedException {

        for (int i = 0; i < 10; i++) {
            int finalI = i;
            new Thread(() -> {
                threadLocal.set(new UserDto().setName("sam"+ finalI));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                log.info("{}:{}",Thread.currentThread().getName(),threadLocal.get().getName());
            }).start();
        }
        UserDto userDto = threadLocal.get();
        UserDto userDto1 = threadLocal1.get();
        System.out.println(userDto.getName()+";"+userDto1.getName());
        Thread.sleep(1000*5);
    }
}
