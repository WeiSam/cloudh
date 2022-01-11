package io.sam.service.impl;

import io.sam.dto.UserDto;
import lombok.extern.slf4j.Slf4j;

/**
 * @author zhuweimu
 * @classname TestService
 * @description
 * @date 2020/11/17 19:39
 */
@Slf4j
public class TestService extends AbstractFaceService<UserDto,UserDto>{

    public static void main(String[] args) {
        TestService testService = new TestService();
        Class type = testService.getClazz();
        System.out.println(type.getName());
    }

    public String test(String msg){
        log.info("io.sam.service.impl.TestService.test,msg = {}",msg);
        return "test"+msg;
    }



}
