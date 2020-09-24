package io.sam;

import io.sam.dto.UserDto;
import org.junit.Test;

import java.text.SimpleDateFormat;

/**
 * @author zhuweimu
 * @Classname ThreadLocalTest
 * @Description
 * @date 2020/9/4 19:45
 */
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
    public void test01(){
        UserDto userDto = threadLocal.get();
        UserDto userDto1 = threadLocal1.get();
        System.out.println(userDto.getName()+";"+userDto1.getName());
    }
}
