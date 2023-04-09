package io.seata.samples.integration.account;

import io.seata.spring.annotation.datasource.EnableAutoDataSourceProxy;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication(scanBasePackages = "io.seata.samples.integration.account")
@MapperScan({"io.seata.samples.integration.account.mapper"})
@EnableDubbo(scanBasePackages = "io.seata.samples.integration.account")
@EnableAutoDataSourceProxy
public class AccountExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountExampleApplication.class, args);
        log.info("账户服务启动完成");
    }

}

