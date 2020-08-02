package io.sam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author: zhuweimu
 * @Date: 2020/8/2 14:35
 * @Description:
 */
@EnableFeignClients
@SpringBootApplication
public class CloudSeataStorage {
    public static void main(String[] args) {
        SpringApplication.run(CloudSeataStorage.class,args);
        System.out.println("账号服务启动成功");
    }
}
