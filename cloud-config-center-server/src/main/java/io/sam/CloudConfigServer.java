package io.sam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @Auther: zhuweimu
 * @Date: 2020/7/19 17:05
 * @Description:
 */
@EnableConfigServer
@SpringBootApplication
public class CloudConfigServer {

    public static void main(String[] args) {
        SpringApplication.run(CloudConfigServer.class,args);
        System.out.println("springcloud config 启动成功");
    }
}
