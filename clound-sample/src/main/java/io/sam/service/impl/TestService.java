package io.sam.service.impl;

import io.sam.dto.UserDto;

/**
 * @author zhuweimu
 * @classname TestService
 * @description
 * @date 2020/11/17 19:39
 */
public class TestService extends AbstractFaceService<UserDto,UserDto>{

    public static void main(String[] args) {
        TestService testService = new TestService();
        Class type = testService.getClazz();
        System.out.println(type.getName());
    }


}
