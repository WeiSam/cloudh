package io.seata.samples.integration.storage;

import io.seata.spring.annotation.datasource.EnableAutoDataSourceProxy;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Slf4j
@EnableTransactionManagement
@SpringBootApplication(scanBasePackages = "io.seata.samples.integration.storage",exclude = {DataSourceAutoConfiguration.class})
@MapperScan({"io.seata.samples.integration.storage.mapper"})
@EnableDubbo(scanBasePackages = "io.seata.samples.integration.storage")
public class StorageXaExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(StorageXaExampleApplication.class, args);
        log.info("库存服务启动完成");
    }

}

