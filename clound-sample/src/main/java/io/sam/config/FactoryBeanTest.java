package io.sam.config;

import io.sam.dto.UserDto;
import org.springframework.beans.factory.FactoryBean;

/**
 * @author zhuweimu
 * @description
 * @date 2021/5/14 17:38
 */
public class FactoryBeanTest implements FactoryBean<UserDto> {

    private String obj;
    private Integer age;

    public FactoryBeanTest(String obj,Integer age) {
        this.obj = obj;
        this.age = age;
    }

    @Override
    public UserDto getObject() throws Exception {
        return new UserDto().setName(obj).setAge(age);
    }

    @Override
    public Class<?> getObjectType() {
        return UserDto.class;
    }
}
