package io.sam.spring;

import io.sam.BaseTest;
import io.sam.service.MyMapperNameTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author zhuweimu
 * @classname MyMapperTest
 * @description
 * @date 2020/11/9 16:54
 */
public class MyMapperTest extends BaseTest {

    @Autowired
    MyMapperNameTest myMapperNameTest;

    @Test
    public void testMyMapper() {
        System.out.println(myMapperNameTest.name());
    }
}
