package io.sam.config;

import io.sam.bean.UserBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhuweimu
 * @description
 * @date 2021/6/16 16:05
 */

public class TestImportConfig {

    @Value("${test.name}")
    private String name;

    @Bean
    public UserBean getUserBean(){
        UserBean userBean = new UserBean();
        userBean.setAge(100);
        userBean.setName(name);
        return userBean;
    }
}
