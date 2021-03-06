package io.sam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author: zhuweimu
 * @Date: 2020/8/2 14:35
 * @Description:
 */
@EnableFeignClients
@SpringBootApplication
public class CloudSeataAcount {
    public static void main(String[] args) {
        SpringApplication.run(CloudSeataAcount.class,args);
        System.out.println("账号服务启动成功");
    }

/*    @Primary
    @Bean("dataSourceProxy")
    public DataSourceProxy dataSourceProxy(@Autowired @Qualifier("druidDataSource") DataSource dataSource) {
        return new DataSourceProxy(dataSource);
    }*/
}
