package io.sam.jdk;

import io.sam.dto.BaseDto;
import io.sam.dto.FatherDto;
import io.sam.dto.SonDto;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
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

    @Test
    public void testAssignableFrom() {
        logger.info("{}",FatherDto.class.isAssignableFrom(SonDto.class));
        logger.info("{}",SonDto.class.isAssignableFrom(FatherDto.class));
        logger.info("{}",FatherDto.class.isAssignableFrom(BaseDto.class));
        logger.info("{}",SonDto.class.isAssignableFrom(BaseDto.class));
        if (new SonDto() instanceof FatherDto) {

        }
    }
}
