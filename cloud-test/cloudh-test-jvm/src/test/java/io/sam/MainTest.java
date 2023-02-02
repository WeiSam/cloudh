package io.sam;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.BitSet;
import java.util.HashSet;
import java.util.Set;
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
        BitSet bitSet = BitSet.valueOf(new long[100000]);
        BitSet bs = new BitSet();
    }

    @Test
    public void testBit() {
        System.out.println(Integer.toBinaryString(1<<6));
    }

    @Test
    public void test0001() {
        Set<String> set = new HashSet<>();
        set.add("12345");
        set.add("abc");
        set.add("adfsdg");
        set.remove("abc");
        System.out.println(JSON.toJSONString(set));
    }
}
