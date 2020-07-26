package io.sam;

import io.ribbon.MyRuleConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @Auther: zhuweimu
 * @Date: 2020/3/28 11:38
 * @Description:
 */
@RibbonClient(name = "cloud-provider-payment",configuration = {MyRuleConfig.class})
@EnableEurekaClient
@SpringBootApplication
public class ConsumerOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerOrderApplication.class,args);
        System.out.println("启动成功");
    }
}
