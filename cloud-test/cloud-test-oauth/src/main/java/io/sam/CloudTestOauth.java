package io.sam;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author: zhuweimu
 * @Date: 2020/11/8 12:46
 * @Description:
 */
@Slf4j
@SpringBootApplication
@MapperScan("io.sam.db")
public class CloudTestOauth {

    public static void main(String[] args) {
        SpringApplication.run(CloudTestOauth.class,args);
        log.info("CloudTestOauth 服务启动成功");
    }
}
