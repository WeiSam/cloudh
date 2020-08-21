package io.sam.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * @Auther: zhuweimu
 * @Date: 2020/3/28 12:14
 * @Description:
 */
@Configuration
public class RestTemplateConfig {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        factory.setReadTimeout(20000);//ms
        factory.setConnectTimeout(20000);//ms
        RestTemplate restTemplate = new RestTemplate(factory);
        return restTemplate;
    }
}
