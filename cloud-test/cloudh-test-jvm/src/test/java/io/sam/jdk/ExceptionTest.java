package io.sam.jdk;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author zhuweimu
 * @description
 * @date 2023/2/2 9:33
 */
@Slf4j
public class ExceptionTest {

    @Test
    public void testThrow() throws Exception {
        try {
            log.info("{}",throwT(1));
        } catch (Exception e) {
            log.info("发生异常");
            throw e;
        }finally {
            log.info("执行finally");
        }
    }

    public String throwT(int num) throws Exception {
        if (num == 1) {
            throw new Exception("异常");
        }
        return "成功";
    }
}
