package io.sam;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author: zhuweimu
 * @Date: 2020/11/8 12:46
 * @Description:
 *
 */
@Slf4j
@MapperScan("io.sam.db")
@SpringBootApplication
public class CloudTestMybatisPlus {

    public static void main(String[] args) {
        SpringApplication.run(CloudTestMybatisPlus.class,args);
        log.info("CloudTestMybatisPlus 服务启动成功");
    }

}
