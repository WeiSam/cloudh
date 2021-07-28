package io.sam.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * @author zhuweimu
 * @classname TestTask
 * @description
 * @date 2021/3/16 17:44
 */
public abstract class TestTask implements RunTask {
    public static String testName = "";

    Logger logger = LoggerFactory.getLogger(TestTask.class);
    public abstract void run() throws Exception;

    @Override
//    @Scheduled(cron = "0/5 * * * * ?")
    public void runTask(){
        try {
            run();
        } catch (Exception e) {
            logger.error("",e);
        }
    }

}
