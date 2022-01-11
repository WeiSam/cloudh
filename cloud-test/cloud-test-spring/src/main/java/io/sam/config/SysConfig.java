package io.sam.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhuweimu
 * @description
 * @date 2021/12/15 9:36
 */
@Configuration
public class SysConfig {

    @Value("${test.name}")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
