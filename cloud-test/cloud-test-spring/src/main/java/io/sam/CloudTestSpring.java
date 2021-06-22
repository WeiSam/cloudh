package io.sam;

import io.sam.config.TestImportConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author: zhuweimu
 * @Date: 2020/11/8 12:46
 * @Description:
 */
@Slf4j
@EnableScheduling
@SpringBootApplication
@Import(TestImportConfig.class)
public class CloudTestSpring {

    public static void main(String[] args) {
        SpringApplication.run(CloudTestSpring.class,args);
        log.info("CloudTestSpring服务启动成功");
    }
}
