package io.sam.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author zhuweimu
 * @classname TestProperties
 * @description
 * @date 2020/9/18 16:37
 */
@Data
@ConfigurationProperties(prefix = "test")
public class TestProperties {

    private String name;
    private Integer age;
}
