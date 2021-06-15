package io.sam.spring;

import io.sam.BaseTest;
import io.sam.config.PrototypeService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author zhuweimu
 * @description
 * @date 2021/5/24 14:51
 */
public class PrototypeTest extends BaseTest {

    @Autowired
    PrototypeService prototypeService;

    /**
     * 目前spring只解决单例模式下的循环依赖问题
     * prototye 范围模式下存在循环依赖会报错
     */
    @Test
    public void testPrototype() {
        prototypeService.test();
    }
}
