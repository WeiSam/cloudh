package io.seata.samples.integration.storage;

import io.seata.spring.annotation.datasource.EnableAutoDataSourceProxy;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication(scanBasePackages = "io.seata.samples.integration.storage")
@MapperScan({"io.seata.samples.integration.storage.mapper"})
@EnableDubbo(scanBasePackages = "io.seata.samples.integration.storage")
@EnableAutoDataSourceProxy
public class StorageExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(StorageExampleApplication.class, args);
        log.info("库存服务启动完成");
    }

}

