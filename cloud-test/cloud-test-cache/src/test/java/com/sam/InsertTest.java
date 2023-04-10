package com.sam;

import io.sam.db.domain.TTest;
import io.sam.db.mapper.TTestMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.CountDownLatch;

/**
 * @author zhuweimu
 * @desc
 * @date 2021/8/29 21:31
 */
public class InsertTest extends BaseTest{

    @Autowired
    TTestMapper tTestMapper;

    @Test
    @Transactional
    public void test01() throws InterruptedException {

        int count = 20;
        CountDownLatch countDownLatch = new CountDownLatch(20);

        for (int i=1;i<=count;i++){
            int finalI = i;
            new Thread(() -> {
                TTest tTest = new TTest();
                tTest.setName("sam"+ finalI);
                tTest.setAge(0);
                tTestMapper.insertSelective(tTest);
                countDownLatch.countDown();
            }).start();
        }

        countDownLatch.await();

        System.out.println("执行结束");
    }

    @Test
    public void test1() {
        TTest tTest = tTestMapper.selectByPrimaryKey(1);
    }
}
