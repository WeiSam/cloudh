package io.sam.service;

import io.sam.annotation.MyMapper;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author zhuweimu
 * @classname MyMapperTest
 * @description
 * @date 2020/11/9 16:52
 */
@MyMapper(name = "MyMapperTest")
public interface MyMapperNameTest {

    String name();

    String age();

    default String defultMethod() {
        return "defultMethod";
    };
}
