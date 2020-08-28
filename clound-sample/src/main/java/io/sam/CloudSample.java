package io.sam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zhuweimu
 * @Classname CloudSample
 * @Description
 * @date 2020/8/24 9:16
 */
@SpringBootApplication
public class CloudSample {
    public static void main(String[] args) {
        SpringApplication.run(CloudSample.class,args);
        System.out.println("启动成功");
    }
}
