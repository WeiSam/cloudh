package io.sam;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author: zhuweimu
 * @Date: 2020/11/8 12:46
 * @Description:
 */
@Slf4j
@SpringBootApplication
public class CloudTestSharding {

    public static void main(String[] args) {
        SpringApplication.run(CloudTestSharding.class,args);
        log.info("CloudTestSharding服务启动成功");
    }
}
