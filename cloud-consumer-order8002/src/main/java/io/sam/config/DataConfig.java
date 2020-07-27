package io.sam.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

/**
 * @author: zhuweimu
 * @Date: 2020/7/27 23:45
 * @Description:
 */
@Data
@RefreshScope
@Configuration
public class DataConfig {

    @Value("${data.env}")
    private String env;

    @Value("${server.port}")
    Integer post;
}
