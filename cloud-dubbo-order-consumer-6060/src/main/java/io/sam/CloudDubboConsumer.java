package io.sam;

import org.apache.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zhuweimu
 * @classname CloudDubboProvider
 * @description
 * @date 2020/11/24 15:27
 */
@SpringBootApplication
@DubboComponentScan(basePackages = "io.sam.service")
public class CloudDubboConsumer {

    public static void main(String[] args) {
        SpringApplication.run(CloudDubboConsumer.class,args);
        System.out.println("CloudDubboConsumer启动成功");
    }
}
