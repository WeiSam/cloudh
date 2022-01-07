package io.sam;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Slf4j
@EnableTransactionManagement
@EnableScheduling
@SpringBootApplication
public class CloudTestCache {

    public static void main(String[] args) {
        SpringApplication.run(CloudTestCache.class,args);
        log.info("CloudTestCache 服务启动成功");
    }
}
