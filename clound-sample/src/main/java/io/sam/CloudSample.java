package io.sam;

import cn.hutool.core.date.DateUtil;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.sam.annotation.EnableDisLock;
import io.sam.annotation.EnableMyMapper;
import io.sam.api.TestServiceApi;
import io.sam.config.InitializingBeanTest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;
import sam.EnableImportTest;

import java.text.SimpleDateFormat;

/**
 * @author zhuweimu
 * @Classname CloudSample
 * @Description
 * @date 2020/8/24 9:16
 */


@EnableDisLock
@EnableScheduling
@SpringBootApplication
@EnableImportTest
@EnableMyMapper
@EnableCaching
@EnableTransactionManagement
@Slf4j
public class CloudSample {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(CloudSample.class, args);
        log.info("启动成功");
    }

    @Bean
    public InitializingBeanTest getInitializingBeanTest(){
        InitializingBeanTest beanTest = new InitializingBeanTest();
        return beanTest;
    }

    @Bean
    public TestServiceApi nonSenseApi(){
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        return new Retrofit.Builder().baseUrl("http://127.0.0.1:1122/")
                .addConverterFactory(JacksonConverterFactory.create(objectMapper))
                .build()
                .create(TestServiceApi.class);
    }
}
