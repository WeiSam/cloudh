package com.sam;

import com.alibaba.fastjson.JSON;
import io.sam.bean.UserBean;
import io.sam.task.TestTask01;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.core.ResolvableType;

/**
 * @author zhuweimu
 * @description
 * @date 2021/6/16 16:19
 */
@Slf4j
public class MainTest {

    @Test
    public void name() {
        ResolvableType resolvableType = ResolvableType.forClass(MainTest.class);
        System.out.println(resolvableType.getSource());
        System.out.println(resolvableType.getGeneric(0).getSource());
        System.out.println(TestTask01.class.getDeclaringClass());
    }
}
