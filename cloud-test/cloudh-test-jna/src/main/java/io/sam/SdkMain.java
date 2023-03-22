package io.sam;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zhuweimu
 * @description
 * @date 2022/4/11 14:59
 */
@Slf4j
@SpringBootApplication
public class SdkMain {

    public static void main(String[] args) {

        SpringApplication.run(SdkMain.class, args);
        log.info("启动成功");
    }
}
