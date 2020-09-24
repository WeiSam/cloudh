package io.sam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author: zhuweimu
 * @Date: 2020/8/4 23:32
 * @Description:
 */
@EnableDiscoveryClient
@SpringBootApplication
public class CloudNacosOrderConsumer {
    public static void main(String[] args) {
        SpringApplication.run(CloudNacosOrderConsumer.class,args);
        System.out.println("NACOS版订单微服务启动成功");
    }
}
