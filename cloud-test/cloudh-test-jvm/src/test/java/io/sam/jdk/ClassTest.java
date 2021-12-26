package io.sam.jdk;

import dto.vo.PaymentVo;
import io.sam.dto.BaseDto;
import io.sam.dto.FatherDto;
import io.sam.dto.SonDto;
import io.sam.dto.UserDto;
import io.sam.oom.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.openjdk.jol.info.ClassLayout;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author zhuweimu
 * @description
 * @date 2021/6/16 14:16
 */
@Slf4j
public class ClassTest {

    Logger logger = LoggerFactory.getLogger(ClassTest.class);

    private static Object obj = new Object();
    private static UserDto userDto = new UserDto();

    @Test
    public void testAssignableFrom() {
        logger.info("{}",FatherDto.class.isAssignableFrom(SonDto.class));
        logger.info("{}",SonDto.class.isAssignableFrom(FatherDto.class));
        logger.info("{}",FatherDto.class.isAssignableFrom(BaseDto.class));
        logger.info("{}",SonDto.class.isAssignableFrom(BaseDto.class));
        if (new SonDto() instanceof FatherDto) {

        }
    }

    @Test
    public void testObject() {
        System.out.println("对象信息");
        System.out.println(ClassLayout.parseInstance(userDto).toPrintable());
        System.out.println("==========对象信息加锁后变化============");
        synchronized (userDto){
            System.out.println(ClassLayout.parseInstance(userDto).toPrintable());
        }
    }
}
