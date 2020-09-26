package io.sam.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Classname MySelfRuleConfig
 * @Description TODO
 * @Date 2020/7/23 10:54
 * @Auther by zhuweimu
 */
@Configuration
public class MySelfRuleConfig {

    @Bean
    public IRule randomRule(){
        return new RandomRule();
    }
}
