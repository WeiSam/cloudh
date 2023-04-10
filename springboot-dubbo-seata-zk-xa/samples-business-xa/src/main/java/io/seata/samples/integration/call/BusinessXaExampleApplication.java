package io.seata.samples.integration.call;

import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@Slf4j
@SpringBootApplication(scanBasePackages = "io.seata.samples.integration.call",
    exclude = {DataSourceAutoConfiguration.class})
@EnableDubbo(scanBasePackages = "io.seata.samples.integration.call")
public class BusinessXaExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(BusinessXaExampleApplication.class, args);
        log.info("业务服务启动完成");
    }

}

