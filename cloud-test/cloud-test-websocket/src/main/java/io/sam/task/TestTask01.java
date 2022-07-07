package io.sam.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class TestTask01 {

    private int count = 0;

//    @Scheduled(cron = "0/2 * * * * ?")
    public void run() throws InterruptedException {
        if (count > 0){
            Thread.sleep(900000000);
        }
        log.info("开始执行,threadName = {},count = {}",Thread.currentThread().getName(),count++);
        Thread.sleep(5000);
    }
}
