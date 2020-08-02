package io.sam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author: zhuweimu
 * @Date: 2020/8/2 14:35
 * @Description:
 */
@SpringBootApplication
@EnableFeignClients
public class CloudSeataBusiness {
    public static void main(String[] args) {
        SpringApplication.run(CloudSeataBusiness.class,args);
        System.out.println("账号服务启动成功");
    }
}
