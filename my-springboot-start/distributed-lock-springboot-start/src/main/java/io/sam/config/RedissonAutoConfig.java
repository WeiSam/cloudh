package io.sam.config;

import io.sam.constant.Constants;
import io.sam.properties.RedissonProperties;
import io.sam.service.LockService;
import io.sam.service.impl.RedissonLockServiceImpl;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.redisson.config.SentinelServersConfig;
import org.redisson.config.SingleServerConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

/**
 * @author zhuweimu
 * @classname RedissonAutoConfig
 * @description
 * @date 2020/9/21 14:10
 */
@ComponentScan(basePackages = "io.sam.service")
@Configuration
@EnableConfigurationProperties(RedissonProperties.class)
public class RedissonAutoConfig {
    Logger log = LoggerFactory.getLogger(RedissonAutoConfig.class);

    @Autowired
    RedissonProperties redissonProperties;

    @Bean
    @ConditionalOnProperty(name = "redisson.address")
    public RedissonClient getRedissonClient(){
        Config config = new Config();
        SingleServerConfig singleServerConfig = config.useSingleServer()
                .setAddress(redissonProperties.getAddress())
                .setTimeout(redissonProperties.getTimeout())
                .setConnectionPoolSize(redissonProperties.getConnectionPoolSize())
                .setConnectionMinimumIdleSize(redissonProperties.getConnectionMinimumIdleSize())
                .setDatabase(redissonProperties.getDatabase());
        if(!StringUtils.isEmpty(redissonProperties.getPassword())) {
            singleServerConfig.setPassword(redissonProperties.getPassword());
        }
        RedissonClient redissonClient = Redisson.create(config);
        log.info("Redisson分布式锁单机模式初始化成功");
        return redissonClient;
    }

    @Bean
    @ConditionalOnProperty(name={"redisson.master-name"})
    RedissonClient redissonSentinel() {
        Config config = new Config();
        SentinelServersConfig serverConfig = config.useSentinelServers().addSentinelAddress(redissonProperties.getSentinelAddresses())
                .setMasterName(redissonProperties.getMasterName())
                .setTimeout(redissonProperties.getTimeout())
                .setMasterConnectionPoolSize(redissonProperties.getMasterConnectionPoolSize())
                .setSlaveConnectionPoolSize(redissonProperties.getSlaveConnectionPoolSize());

        if(!StringUtils.isEmpty(redissonProperties.getPassword())) {
            serverConfig.setPassword(redissonProperties.getPassword());
        }
        log.info("Redisson分布式锁哨兵模式初始化成功");
        RedissonClient redissonClient = Redisson.create(config);
        return redissonClient;
    }

    @ConditionalOnBean(RedissonClient.class)
    @Bean(Constants.REDISSON_LOCK_SERVICE)
    public LockService redissonLockServiceImpl(){
        return new RedissonLockServiceImpl();
    }
}
