package io.seata.samples.integration.order;

import io.seata.spring.annotation.datasource.EnableAutoDataSourceProxy;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication(scanBasePackages = "io.seata.samples.integration.order")
@MapperScan({"io.seata.samples.integration.order.mapper"})
@EnableDubbo(scanBasePackages = "io.seata.samples.integration.order")
@EnableAutoDataSourceProxy
public class OrderExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderExampleApplication.class, args);
        log.info("订单服务启动完成");
    }

}

