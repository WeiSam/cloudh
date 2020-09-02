package io.sam.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix = "sam.json")
public class MyJsonProperties {

    public static final String DEFAULT_NAME = "sam";

    private String prefixName = DEFAULT_NAME;

    public String getPrefixName() {
        return prefixName;
    }

    public void setPrefixName(String prefixName) {
        this.prefixName = prefixName;
    }
}