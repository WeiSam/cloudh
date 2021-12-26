package io.sam;

import org.junit.Test;

/**
 * @author zhuweimu
 * @classname MainTest
 * @description
 * @date 2021/2/8 14:23
 */
public class MainTest {

    @Test
    public void testclassLoad() {
        System.out.println(Integer.class.getClassLoader());
        System.out.println(ClassLoader.getSystemClassLoader());
        System.out.println(ClassLoader.getSystemClassLoader().getParent());
        System.out.println(ClassLoader.getSystemClassLoader().getParent().getParent());
        System.out.println(ClassLoader.getSystemClassLoader().getParent().getParent().getParent());
    }
}
