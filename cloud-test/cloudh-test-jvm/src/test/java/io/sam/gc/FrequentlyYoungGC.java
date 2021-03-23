package io.sam.gc;

import org.junit.Test;

/**
 * @author zhuweimu
 * @classname FrequentlyYoungGC
 * @description
 * @date 2021/2/18 16:48
 */
public class FrequentlyYoungGC {

    /**
     *-XX:NewSize=104857600 -XX:MaxNewSize=104857600 -XX:InitialHeapSize=209715200 -XX:MaxHeapSize=209715200 -XX:SurvivorRatio=8  -XX:MaxTenuringThreshold=15 -XX:PretenureSizeThreshold=3145728 -XX:+UseParNewGC -XX:+UseConcMarkSweepGC -XX:+PrintGCDetails -XX:+PrintGCTimeStamps
     *
     */
    @Test
    public void testYoungGC() {

    }

    /**
     * -XX:NewSize=104857600 -XX:MaxNewSize=104857600 -XX:InitialHeapSize=209715200 -XX:MaxHeapSize=209715200 -XX:SurvivorRatio=8  -XX:MaxTenuringThreshold=15 -XX:PretenureSizeThreshold=3145728 -XX:+UseParNewGC -XX:+UseConcMarkSweepGC -XX:+PrintGCDetails -XX:+PrintGCTimeStamps -Xloggc:gc.log
     *
     * 模拟频繁YoungGC
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        System.out.println("开始执行");
        Thread.sleep(50*1000);
        while (true){
            loadData();
        }
    }

    private static void loadData() throws InterruptedException {
        byte [] data = null;
        for (int i = 0; i < 50; i++) {
            data = new byte[1024*100];
        }
        data = null;
        Thread.sleep(1000);
    }


}
