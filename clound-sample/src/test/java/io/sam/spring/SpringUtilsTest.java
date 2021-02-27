package io.sam.spring;

import com.alibaba.fastjson.JSON;
import io.sam.dto.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.PropertyAccessorFactory;

/**
 * @author zhuweimu
 * @classname SpringUtilsTest
 * @description
 * @date 2020/10/20 13:42
 */
@Slf4j
public class SpringUtilsTest {

    @Test
    public void testAnnotationConfigUtils(){
//        AnnotationConfigUtils.attributesFor(null, Scope.class);

    }

    @Test
    public void testPropertyAccessorFactory() {
        UserDto userDto = new UserDto();
        userDto.setName("sam");
        userDto.setAge(0);
        BeanWrapper beanWrapper = PropertyAccessorFactory.forBeanPropertyAccess(userDto);
        System.out.println(JSON.toJSONString(beanWrapper));
    }
}
