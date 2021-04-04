package io.sam.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class TestTask03 {

    @Scheduled(cron = "0/2 * * * * ?")
    public void run() throws InterruptedException {
        log.info("开始执行,threadName = {}",Thread.currentThread().getName());
        Thread.sleep(5000);
    }
}
