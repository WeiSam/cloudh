package io.sam.jdk8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author zhuweimu
 * @classname StreamTest
 * @description
 * @date 2021/1/7 16:42
 */
public class StreamTest {

    private static CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
    private static List<Integer> list1 = new ArrayList<>();
    private static List<Integer> list2 = new ArrayList<>();
    private static List<Integer> list3 = new ArrayList<>();
    private static Lock lock = new ReentrantLock();
    private static Integer count = 0;

    /**
     * 并发流非收集汇总操作时会有线程安全问题
     */
    @Test
    public void testParallelStream() {

        IntStream.range(0, 10000).forEach(list1::add);

        //并发流可能会有线程安全问题,导致遍历错漏,多线程读取到同下标
        IntStream.range(0, 10000).parallel().forEach(list2::add);

        //收集终止操作可以避免,是线程安全的,或者使用线程安全的集合来操作
        List<Integer> copy = list1.parallelStream().collect(Collectors.toList());
        IntStream.range(0, 10000).parallel().forEach(copyOnWriteArrayList::add);

        IntStream.range(0, 10000).parallel().forEach(i -> {
            //多线程,导致累加重复
            count++;
            lock.lock();
            try {
                list3.add(i);
            }finally {
                lock.unlock();
            }
        });

        System.out.println("串行执行的大小：" + list1.size());
        System.out.println("并行执行的大小：" + list2.size());
        System.out.println("加锁并行执行的大小：" + list3.size());
        System.out.println("收集终止操作的大小:"+copy.size());
        System.out.println("线程安全的集合:"+copyOnWriteArrayList.size());
        System.out.println("并发流执行次数:"+count);
    }
}
