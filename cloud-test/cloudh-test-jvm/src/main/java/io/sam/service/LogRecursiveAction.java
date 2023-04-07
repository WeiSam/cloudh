package io.sam.service;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.RecursiveAction;

/**
 * @author zhuweimu
 * @description 无返回值，并发执行任务，打印数值,小任务最多打印10个
 * @date 2023/4/6 10:28
 */
@Slf4j
public class LogRecursiveAction extends RecursiveAction {

    private Integer min;
    private Integer max;

    private Integer maxCout = 10;

    private LogRecursiveAction(){}

    public LogRecursiveAction(Integer min, Integer max) {
        this.min = min;
        this.max = max;
    }

    @Override
    protected void compute() {
        if (this.max - this.min <= maxCout) {
            for (int i = this.min; i <= this.max; i++) {
                log.info("当前线程:{},打印数值:{}",Thread.currentThread().getName(),i);
            }
        }else {
            //二分法拆分任务
            int middle = (max + min) / 2;
            LogRecursiveAction left = new LogRecursiveAction(min, middle);
            LogRecursiveAction right = new LogRecursiveAction(middle+1,max);
            left.fork();
            right.fork();
        }

    }
}
