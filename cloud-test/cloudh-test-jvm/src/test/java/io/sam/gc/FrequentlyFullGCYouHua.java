package io.sam.gc;

/**
 * @author zhuweimu
 * @classname FrequentlyYoungGC
 * @description
 * @date 2021/2/18 16:48
 */
public class FrequentlyFullGCYouHua {

    public static int M = 1024*1024;

    /**
     * -XX:NewSize=104857600 -XX:MaxNewSize=104857600 -XX:InitialHeapSize=209715200 -XX:MaxHeapSize=209715200 -XX:SurvivorRatio=8  -XX:MaxTenuringThreshold=15 -XX:PretenureSizeThreshold=20971520 -XX:+UseParNewGC -XX:+UseConcMarkSweepGC -XX:+PrintGCDetails -XX:+PrintGCTimeStamps
     *
     * 模拟频繁FullGC
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        System.out.println("开始执行");
        Thread.sleep(20*1000);
        while (true){
            loadData();
        }
    }

    private static void loadData() throws InterruptedException {
        byte [] data = null;
        for (int i = 0; i < 4; i++) {
            data = new byte[10*M];
        }
        data = null;
        byte [] data1 = new byte[10*M];
        byte [] data2 = new byte[10*M];
        byte [] data3 = new byte[10*M];
        data3 = new byte[10*M];
        Thread.sleep(1000);
    }
}
