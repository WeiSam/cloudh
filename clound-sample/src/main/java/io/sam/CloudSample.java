package io.sam;

import io.sam.annotation.EnableMyMapper;
import io.sam.config.InitializingBeanTest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import sam.EnableImportTest;

/**
 * @author zhuweimu
 * @Classname CloudSample
 * @Description
 * @date 2020/8/24 9:16
 */
@EnableScheduling
@SpringBootApplication
@EnableImportTest
@EnableMyMapper
@EnableCaching
@EnableTransactionManagement
public class CloudSample {
    public static void main(String[] args) {
        SpringApplication.run(CloudSample.class,args);
        System.out.println("启动成功");
    }

//    @Bean
    public InitializingBeanTest getInitializingBeanTest(){
        InitializingBeanTest beanTest = new InitializingBeanTest();
        return beanTest;
    }
}
