package io.sam.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringEncoder;
import org.junit.Test;

import java.util.concurrent.CountDownLatch;

/**
 * @author zhuweimu
 * @desc
 * @date 2021/12/11 20:59
 */
public class HelloClient {

    public static void main(String[] args) throws InterruptedException {
        new Bootstrap()
                .group(new NioEventLoopGroup())
                .channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<NioSocketChannel>() {
                    @Override
                    protected void initChannel(NioSocketChannel nioSocketChannel) throws Exception {
                        nioSocketChannel.pipeline().addLast(new StringEncoder());
                    }
                })
                .connect("127.0.0.1",8080)
                .sync()
                .channel()
                .writeAndFlush("Hello World");
    }

    @Test
    public void helloClient() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        new Thread(() -> {
            try {
                new Bootstrap()
                        .group(new NioEventLoopGroup())
                        .channel(NioSocketChannel.class)
                        .handler(new ChannelInitializer<NioSocketChannel>() {
                            @Override
                            protected void initChannel(NioSocketChannel nioSocketChannel) throws Exception {
                                nioSocketChannel.pipeline().addLast(new StringEncoder());
                            }
                        })
                        .connect("127.0.0.1",8088)
                        .sync()
                        .channel()
                        .writeAndFlush("Hello World");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        countDownLatch.await();

    }
}
