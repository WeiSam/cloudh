package io.sam.service;

import com.alibaba.fastjson.JSON;
import io.sam.BaseTest;
import io.sam.db.domain.Userinfo;
import io.sam.db.mapper.UserinfoMapper;
import io.sam.db.service.UserinfoService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;

import javax.annotation.Resource;
import java.util.concurrent.CountDownLatch;

/**
 * @author zhuweimu
 * @description
 * @date 2021/8/10 9:49
 */
@Slf4j
public class TestTransaction extends BaseTest {

    @Autowired
    UserinfoService userinfoService;

    @Autowired
    UserinfoMapper userinfoMapper;


    /**
     * 自动装配
     * 自动装配类：
     * TransactionAutoConfiguration.java
     */
    @Resource
    private TransactionTemplate transactionTemplate ;

    @Transactional
    @Test
    public void test01() {
        Userinfo userinfo = userinfoService.selectByPrimaryKey(1);
        log.info("USER:{}", JSON.toJSONString(userinfo));
        userinfo.setAge(78);
        userinfoService.updateByPrimaryKeySelective(userinfo);
        userinfo = userinfoService.selectByPrimaryKey(1);
        log.info("USER2:{}", JSON.toJSONString(userinfo));
        transactionTemplate.execute(status -> {

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                status.setRollbackOnly();
            }
            return null;
        });

    }

    @Test
    public void test02() throws InterruptedException {
        int count = 20;
        CountDownLatch countDownLatch = new CountDownLatch(count);
        for (int i = 1; i <= count; i++) {
            int finalI = i;
            new Thread(() -> {
                Userinfo userinfo = new Userinfo();
                userinfo.setName("sam"+ finalI);
                userinfo.setNum(0);
                userinfoMapper.insertSelective(userinfo);
                countDownLatch.countDown();
            }).start();
        }
        countDownLatch.await();

        log.info("执行结束");
    }
}
