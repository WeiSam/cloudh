package io.sam.config;

import io.sam.constant.Constants;
import io.sam.properties.CuratorProperties;
import io.sam.service.LockService;
import io.sam.service.impl.CuratorLockServiceImpl;
import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhuweimu
 * @classname CuratorAutoConfig
 * @description
 * @date 2020/9/23 19:14
 */
@ComponentScan(basePackages = "io.sam.service")
@Configuration
@EnableConfigurationProperties(CuratorProperties.class)
public class CuratorAutoConfig {

    Logger log = LoggerFactory.getLogger(CuratorAutoConfig.class);
    @Autowired
    CuratorProperties curatorProperties;

    @Bean
    @ConditionalOnProperty(name = "curator.zoo.enabled",havingValue = "true")
    public CuratorFramework curatorFramework(){
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(curatorProperties.getBaseSleepTimeMs(), curatorProperties.getMaxRetries());
        CuratorFramework client = CuratorFrameworkFactory.builder()
                .connectString(curatorProperties.getConnectString())
                .connectionTimeoutMs(curatorProperties.getConnectionTimeoutMs())
                .sessionTimeoutMs(curatorProperties.getSessionTimeoutMs())
                .retryPolicy(retryPolicy)
                .namespace(curatorProperties.getNamespace())
                .build();
        client.start();
        log.info("Curator初始化成功");
        return client;
    }

    @Bean(Constants.CURATOR_LOCK_SERVICE)
    @ConditionalOnBean(CuratorFramework.class)
    public LockService curatorLockServiceImpl(){
        return new CuratorLockServiceImpl();
    }

}
