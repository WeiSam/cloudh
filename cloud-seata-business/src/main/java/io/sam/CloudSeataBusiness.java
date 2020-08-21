package io.sam;

import io.seata.rm.datasource.DataSourceProxy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * @author: zhuweimu
 * @Date: 2020/8/2 14:35
 * @Description:
 */
@SpringBootApplication
@EnableFeignClients
public class CloudSeataBusiness {
    public static void main(String[] args) {
        SpringApplication.run(CloudSeataBusiness.class,args);
        System.out.println("服务启动成功");
    }

    @Primary
    @Bean("dataSourceProxy")
    public DataSourceProxy dataSourceProxy(DataSource dataSource) {
        return new DataSourceProxy(dataSource);
    }
}
