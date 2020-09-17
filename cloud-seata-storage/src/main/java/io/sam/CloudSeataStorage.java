package io.sam;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author: zhuweimu
 * @Date: 2020/8/2 14:35
 * @Description:
 */
@MapperScan(basePackages = {"io.sam.mapper"})
@EnableFeignClients
@SpringBootApplication
public class CloudSeataStorage {
    public static void main(String[] args) {
        SpringApplication.run(CloudSeataStorage.class,args);
        System.out.println("库存服务启动成功");
    }

/*    @Primary
    @Bean("dataSourceProxy")
    public DataSourceProxy dataSourceProxy(@Autowired @Qualifier("druidDataSource") DataSource dataSource) {
        return new DataSourceProxy(dataSource);
    }*/
}
