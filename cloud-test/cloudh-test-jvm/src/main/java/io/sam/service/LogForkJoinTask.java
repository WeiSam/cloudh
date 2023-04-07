package io.sam.service;

import java.util.concurrent.ForkJoinTask;

/**
 * @author zhuweimu
 * @description
 * @date 2023/4/6 10:25
 */
public class LogForkJoinTask extends ForkJoinTask {
    @Override
    public Object getRawResult() {
        return null;
    }

    @Override
    protected void setRawResult(Object value) {

    }

    @Override
    protected boolean exec() {
        return false;
    }
}
