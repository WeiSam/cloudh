package io.sam.service;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.RecursiveTask;

/**
 * @author zhuweimu
 * @description 累加
 * @date 2023/4/6 10:48
 */
@Slf4j
public class AddRecursiveTask extends RecursiveTask<Integer> {

    private Integer min;
    private Integer max;

    private Integer maxCout = 10;

    public AddRecursiveTask(Integer min, Integer max) {
        this.min = min;
        this.max = max;
    }

    @Override
    protected Integer compute() {
        int total = 0;
        if (this.max - this.min <= maxCout) {
            for (int i = this.min; i <= this.max; i++) {
                total += i;
            }
        }else {
            //二分法拆分任务
            int middle = (max + min) / 2;
            AddRecursiveTask left = new AddRecursiveTask(min, middle);
            AddRecursiveTask right = new AddRecursiveTask(middle+1,max);
            left.fork();
            right.fork();
            //任务结果合并
            return left.join() + right.join();
        }
        return total;
    }
}
