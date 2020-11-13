package io.sam;

import io.sam.service.MyMapperNameTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * @author zhuweimu
 * @classname ModifierTest
 * @description
 * @date 2020/11/10 11:06
 */
@Slf4j
public class ModifierTest {

    @Test
    void testModifier() {
        int aps = Modifier.ABSTRACT | Modifier.PUBLIC | Modifier.STATIC;
        log.info("Modifier.ABSTRACT = {}",Modifier.ABSTRACT);
        log.info("(Modifier.ABSTRACT | Modifier.PUBLIC | Modifier.STATIC) = {}",aps);
        Method[] methods = MyMapperNameTest.class.getMethods();
        for (Method method : methods) {
            log.info("{},{},{}",method.getName(),method.getModifiers(),method.getModifiers()&aps);
        }
    }
}
