package io.sam.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author zhuweimu
 * @classname TestTask01
 * @description
 * @date 2021/3/16 16:53
 */
@Component
public class TestTask02 extends TestTask {

    Logger logger = LoggerFactory.getLogger(TestTask02.class);

    @Override
    public void run() throws Exception {
        logger.info("开始执行,threadName = {}",Thread.currentThread().getName());
        Thread.sleep(1000);
    }
}
