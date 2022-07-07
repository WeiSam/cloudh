package io.sam.config;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.benmanes.caffeine.cache.CacheLoader;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import io.sam.cache.CaffeineCaches;
import io.sam.cache.RedisCaches;
import io.sam.db.domain.AccountTbl;
import io.sam.db.mapper.AccountTblMapper;
import io.sam.db.service.AccountTblService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCache;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.cache.support.CompositeCacheManager;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;

import javax.annotation.Priority;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Slf4j
@Configuration
@EnableCaching
public class SpringCacheConfig {

	@Autowired
	AccountTblService accountTblService;

	@Autowired
	private AccountTblMapper accountTblMapper;

	ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10,15,1000, TimeUnit.SECONDS,
			new LinkedBlockingQueue<>(1000),
			new ThreadFactoryBuilder().setNameFormat("SpringCache-Pool-%d").build(),
			new ThreadPoolExecutor.CallerRunsPolicy());

	/**
	 * 混合缓存管理
	 * 如果多个CacheManager中有相同的cacheName时
	 * 则按照spring获取bean的顺序来执行 beanFactory.getBean(CacheManager.class)
	 * 遍历CacheManager,能拿到对应Cache则返回
	 *
	 * @return cacheManager
	 */
	@Primary
	@Bean
	public CacheManager compositeCacheManager(@Autowired RedisConnectionFactory connectionFactory) {
		CacheManager redisCacheManager = reidsCacheManager(connectionFactory);
		CacheManager caffeineCacheManager = caffeineCacheManager();
		//使用优先级按照添加顺序获取
		CompositeCacheManager cacheManager = new CompositeCacheManager(caffeineCacheManager, redisCacheManager);
		//是否使用默认的NoOpCacheManager,空操作,不会缓存
		cacheManager.setFallbackToNoOpCache(true);
		return cacheManager;
	}

	public RedisSerializationContext.SerializationPair<Object> pair() {
		Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
		ObjectMapper om = new ObjectMapper();
		om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
		om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
		jackson2JsonRedisSerializer.setObjectMapper(om);

		RedisSerializationContext.SerializationPair<Object> pair = RedisSerializationContext.SerializationPair.fromSerializer(jackson2JsonRedisSerializer);
		return pair;
	}

	public CacheManager reidsCacheManager(RedisConnectionFactory connectionFactory) {
		RedisCacheConfiguration defaultConfig = RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofSeconds(300)).serializeValuesWith(pair())
				.disableCachingNullValues();
		Map<String, RedisCacheConfiguration> cacheConfigurationMap = new HashMap<>();
		for (RedisCaches cache : RedisCaches.values()) {
			RedisCacheConfiguration redisCacheConfiguration = defaultConfig.entryTtl(Duration.ofSeconds(cache.getTtl()));
			cacheConfigurationMap.put(cache.name(), redisCacheConfiguration);
		}
		RedisCacheManager redisCacheManager = RedisCacheManager
				.builder(connectionFactory)
				.cacheDefaults(defaultConfig)
				.withInitialCacheConfigurations(cacheConfigurationMap)
				.transactionAware()
				.build();
		redisCacheManager.initializeCaches();// 这个是必须初始化 CONNECT_POINT_X
		return redisCacheManager;
	}

	public CacheManager caffeineCacheManager() {
		SimpleCacheManager cacheManager = new SimpleCacheManager();
		List<CaffeineCache> caches = new ArrayList<>();
		for (CaffeineCaches cache : CaffeineCaches.values()) {
			caches.add(new CaffeineCache(cache.name(),
					Caffeine.newBuilder()
							.maximumSize(cache.getMaxSize())
							.expireAfterWrite(10, TimeUnit.SECONDS)
							.refreshAfterWrite(5,TimeUnit.SECONDS)
							.build(new CacheLoader<Object, Object>() {

								@Override
								public Object load(Object key) throws Exception {
									AccountTbl accountTbl = accountTblService.selectByPrimaryKeyNotCache((Integer) key);
									log.info("===========加载数据()===========,{}", JSON.toJSONString(accountTbl));
									return accountTbl;
								}
							})));
		}
		cacheManager.setCaches(caches);
		cacheManager.initializeCaches();
		return cacheManager;
	}

}