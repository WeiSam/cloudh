package io.sam;

import io.netty.util.NettyRuntime;
import org.junit.Test;

import java.nio.channels.FileChannel;

/**
 * @author zhuweimu
 * @classname MainTest
 * @description
 * @date 2021/2/8 14:23
 */
public class MainTest {

    @Test
    public void test01() {
        System.out.println("结果："+NettyRuntime.availableProcessors());
    }
}
