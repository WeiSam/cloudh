package io.sam.gc;

import org.junit.Test;
import sun.nio.ch.DirectBuffer;

import java.nio.ByteBuffer;
import java.util.concurrent.TimeUnit;

/**
 * @author zhuweimu
 * @classname YongGcTest
 * @description
 * @date 2021/2/8 14:24
 */
public class GcTest {

    public static int K = 1024;
    public static int M = 1024*1024;

    /**
     * 演示YoungGC
     * 启动jvm配置 jdk8
     * -XX:NewSize=5242880 -XX:MaxNewSize=5242880 -XX:InitialHeapSize=10485760 -XX:MaxHeapSize=10485760 -XX:SurvivorRatio=8 -XX:PretenureSizeThreshold=10485760 -XX:+UseParNewGC -XX:+UseConcMarkSweepGC -XX:+PrintGCDetails -XX:+PrintGCTimeStamps -Xloggc:gc.log
     * -XX:NewSize=5242880 初始化新生代大小
     * -XX:MaxNewSize=5242880   最大新生代大小
     * -XX:InitialHeapSize=10485760 初始化堆内存大小
     * -XX:MaxHeapSize=10485760 最大堆内存大小
     * -XX:SurvivorRatio=8 Eden和两个survivor 比例
     * -XX:PretenureSizeThreshold=10485760 大对象阈值
     * -XX:+UseParNewGC 使用年轻代垃圾回收器parnew
     * -XX:+UseConcMarkSweepGC 使用老年代垃圾回收器CMS
     * -XX:+PrintGCDetails 打印GC日志
     * -XX:+PrintGCTimeStamps
     * -Xloggc:gc.log   指定GC日志文件保存路径
     */
    @Test
    public void testYoungGc() {
        byte [] array = new byte[M];
        array = new byte[1*M];
        array = new byte[1*M];
        array = null;
        array = new byte[2*M];
    }

    /**
     * 动态年龄判定规则
     * 1.躲过15次gc，达到15岁高龄之后进入老年代；
     * 2.动态年龄判定规则，如果Survivor区域内年龄1+年龄2+年龄3+年龄n的对象总和大于Survivor区的50%，此时年龄n以上的对象会进入老年代，不一定要达到15岁
     * 3.如果一次Young GC后存活对象太多无法放入Survivor区，此时直接计入老年代
     * 4.大对象直接进入老年代
     * -XX:NewSize=10485760 -XX:MaxNewSize=10485760 -XX:InitialHeapSize=20971520 -XX:MaxHeapSize=20971520 -XX:SurvivorRatio=8  -XX:MaxTenuringThreshold=15 -XX:PretenureSizeThreshold=10485760 -XX:+UseParNewGC -XX:+UseConcMarkSweepGC -XX:+PrintGCDetails -XX:+PrintGCTimeStamps -Xloggc:gc.log
     */
    @Test
    public void testDynamicAge() {
        byte [] array = new byte[2 * M];
        array = new byte[2 * M];
        array = new byte[2 * M];
        array = null;
        byte [] array1 = new byte[128 * K];
        byte [] array2 = new byte[2 * M];
    }

    @Test
    public void testHeap() throws InterruptedException {
        try {
            for (int i = 0; i < 1; i++) {
                ByteBuffer byteBuffer = ByteBuffer.allocateDirect(1024*1024*100);
                TimeUnit.SECONDS.sleep(1);
                ((DirectBuffer)byteBuffer).cleaner().clean();
                TimeUnit.SECONDS.sleep(2);
                ((DirectBuffer)byteBuffer).cleaner().clean();
                TimeUnit.SECONDS.sleep(5);
                ((DirectBuffer)byteBuffer).cleaner().clean();
                System.out.println("内存回收结束");
            }
            TimeUnit.SECONDS.sleep(60*2);

    } catch (Exception e) {
        e.printStackTrace();
    }
    }
}
