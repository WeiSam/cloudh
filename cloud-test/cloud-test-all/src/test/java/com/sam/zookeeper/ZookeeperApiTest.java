package com.sam.zookeeper;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.zookeeper.*;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * @author zhuweimu
 * @description
 * @date 2023/2/2 16:04
 */
@Slf4j
public class ZookeeperApiTest {

    public static ZooKeeper zooKeeper = null;
    final CountDownLatch countDownLatch=new CountDownLatch(1);

    @BeforeClass
    public static void beforeClass() throws Exception {
        zooKeeper = new ZooKeeper("127.0.0.1:2181", 1000, new Watcher() {
            @Override
            public void process(WatchedEvent event) {
                Event.EventType nodeDataChanged = Event.EventType.NodeDataChanged;
                log.info("连接zookeeper,event = {}", JSON.toJSONString(event));
            }
        });
    }

    @Test
    public void testApi() throws IOException, InterruptedException {
        ZooKeeper zk = new ZooKeeper("127.0.0.1:2181", 1000, new Watcher() {
            @Override
            public void process(WatchedEvent event) {
                log.info("连接zookeeper,event = {},{}", JSON.toJSONString(event),event.getType());
                if(Event.KeeperState.SyncConnected==event.getState()){
                    //如果收到了服务端的响应事件，连接成功
                    countDownLatch.countDown();
                }
            }
        });
        countDownLatch.await();
        log.info("{}",zk.getState());
    }

    @Test
    public void testApi01() throws KeeperException, InterruptedException {
        String s = zooKeeper.create("/test","0asdfsjkghj".getBytes(),ZooDefs.Ids.OPEN_ACL_UNSAFE,CreateMode.PERSISTENT);
        log.info("结果：{}",s);
    }

    @Test
    public void testApi02() throws KeeperException, InterruptedException {
        byte[] data = zooKeeper.getData("/test", null, null);
        log.info("结果：{}",new String(data));
    }

    @Test
    public void testWatch() throws KeeperException, InterruptedException {
        //为true则默认使用创建zooKeeper客户端时的监听器
        byte[] data = zooKeeper.getData("/test", true, null);

        zooKeeper.setData("/test","123".getBytes(),10);
        log.info("结果：{}",new String(data));
        countDownLatch.await();
    }
}
