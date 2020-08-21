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
public class CloudNacosProviderPayment {
    public static void main(String[] args) {
        SpringApplication.run(CloudNacosProviderPayment.class,args);
        System.out.println("NACOS版支付微服务启动成功");
    }
}
