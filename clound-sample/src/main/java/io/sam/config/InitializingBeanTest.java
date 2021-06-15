package io.sam.config;

import io.sam.dto.UserDto;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * @author zhuweimu
 * @classname InitializingBeanTest
 * @description
 * @date 2020/10/27 10:49
 */
@Data
@Slf4j
public class InitializingBeanTest implements InitializingBean, FactoryBean<UserDto> {
    private String name;

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("afterPropertiesSet初始化之前,name = {}",name);
        name = "test";
    }

    @Override
    public UserDto getObject(){
        return new UserDto().setName(name);
    }

    @Override
    public Class<?> getObjectType() {
        return UserDto.class;
    }
}
