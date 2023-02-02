package io.sam.service.impl;

import io.sam.dto.UserDto;
import io.sam.service.MyMapperNameTest;
import lombok.extern.slf4j.Slf4j;

/**
 * @author zhuweimu
 * @classname TestService
 * @description
 * @date 2020/11/17 19:39
 */
@Slf4j
public class TestService extends AbstractFaceService<UserDto,UserDto> implements MyMapperNameTest {

    public static void main(String[] args) {
        TestService testService = new TestService();
        Class type = testService.getClazz();
        System.out.println(type.getName());
    }

    private String test(String msg){
        log.info("io.sam.service.impl.TestService.test,msg = {}",msg);
        return "test"+msg;
    }

    public final String testFinal(){
        log.info("代理final修饰的方法");
        test("通过其他方法调用");
        return "final修饰的方法";
    }


    @Override
    public String name() {
        return null;
    }

    @Override
    public String age() {
        return null;
    }
}
