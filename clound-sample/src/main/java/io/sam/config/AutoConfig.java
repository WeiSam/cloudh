package io.sam.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhuweimu
 * @classname AutoConfig
 * @description
 * @date 2020/9/18 16:36
 */
@Data
@Configuration
@EnableConfigurationProperties(TestProperties.class)
public class AutoConfig {
    @Autowired
    TestProperties testProperties;
}
