package io.sam.jdk;

import io.sam.dto.UserDto;
import org.junit.Test;

import java.util.PriorityQueue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * @author zhuweimu
 * @classname QueueTest
 * @description
 * @date 2021/2/19 14:47
 */
public class QueueTest {

    @Test
    public void testPriorityQueue() {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(2);
        priorityQueue.add(1);
        priorityQueue.add(3);
        priorityQueue.add(0);
        priorityQueue.add(1);
        priorityQueue.add(2);
        priorityQueue.add(1);
        System.out.println(priorityQueue.size());
        for (int i = 0; i < 7; i++) {
            System.out.println(priorityQueue.poll());
        }
    }

    @Test
    public void testBlockingQueue() {
        ArrayBlockingQueue<UserDto> arrayBlockingQueue = new ArrayBlockingQueue<>(16);

        PriorityBlockingQueue<UserDto> priorityBlockingQueue = new PriorityBlockingQueue<>();
    }
}
