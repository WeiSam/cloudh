package io.sam.netty.eventloop;

import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.util.NettyRuntime;
import org.junit.Test;

/**
 * @author zhuweimu
 * @desc eventloop 本质是一个单线程的执行器selector，不断执行channel上的事件
 * @date 2022/1/3 11:05
 */
public class EventLoopTest {

    @Test
    public void testEventloopGroup() {
        //创建事件循环组对象
        //可以处理io、普通任务、定时任务
        NioEventLoopGroup eventLoopGroup = new NioEventLoopGroup();
        System.out.println("结果："+NettyRuntime.availableProcessors());
    }
}
