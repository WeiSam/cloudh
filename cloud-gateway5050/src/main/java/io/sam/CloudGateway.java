package io.sam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author: zhuweimu
 * @Date: 2020/8/30 12:39
 * @Description:
 */
@EnableEurekaClient
@SpringBootApplication
public class CloudGateway {

    public static void main(String[] args) {
        SpringApplication.run(CloudGateway.class,args);
        System.out.println("网关服务启动成功");
    }
}
