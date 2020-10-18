package io.sam.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhuweimu
 * @classname RabbitMqConfig
 * @description
 * @date 2020/9/29 10:11
 */
@Configuration
public class RabbitMqConfig {

    public String name;

    @Bean
    public Jackson2JsonMessageConverter jackson2JsonMessageConverter(ObjectMapper xssObjectMapper) {
        return new Jackson2JsonMessageConverter(xssObjectMapper);
    }
}
