package io.sam.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * @author: zhuweimu
 * @Date: 2020/8/9 18:26
 * @Description:
 */
@Configuration
@Getter
public class OrderConfig {

    @Value("${service.payment.name}")
    private String paymentService;

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        factory.setReadTimeout(20000);//ms
        factory.setConnectTimeout(20000);//ms
        RestTemplate restTemplate = new RestTemplate(factory);
        return restTemplate;
    }
}
