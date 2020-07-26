package io.ribbon;

import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: zhuweimu
 * @Date: 2020/7/26 12:36
 * @Description: ribbon负载均衡规则配置,若是配置在主启动类@ComponentScan包扫描路径下
 * ，则表示全局配置，配置以外路径可不同服务制定化规则
 */
@Configuration
public class MyRuleConfig {

/*    @Bean
    public RandomRule getRandomRule(){
        return new RandomRule();
    }*/

    @Bean
    public RoundRobinRule getRoundRobinRule(){
        return new RoundRobinRule();
    }
}
