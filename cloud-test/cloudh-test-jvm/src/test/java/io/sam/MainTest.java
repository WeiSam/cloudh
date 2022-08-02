package io.sam;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    @Test
    public void testGitStash() {

    }

    @Test
    public void test001() {
        String str = "990102199002102937";
        String pattern = "\\d{17}[\\d|x]|\\d{15}";

        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(str);
        System.out.println(m.matches());
    }
}
