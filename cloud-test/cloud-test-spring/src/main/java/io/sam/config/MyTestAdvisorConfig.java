package io.sam.config;

import io.sam.aop.advisor.MyTestAdvisor;
import io.sam.aop.advisor.MyTestAdvisorInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhuweimu
 * @description
 * @date 2021/8/3 16:48
 */
@Configuration
public class MyTestAdvisorConfig {

    @Bean
    public MyTestAdvisor myTestAdvisor(){
        MyTestAdvisor myTestAdvisor = new MyTestAdvisor();
        myTestAdvisor.setAdvice(new MyTestAdvisorInterceptor());
        return myTestAdvisor;
    }
}
