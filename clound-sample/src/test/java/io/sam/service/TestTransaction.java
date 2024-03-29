package io.sam.service;

import com.alibaba.fastjson.JSON;
import io.sam.BaseTest;
import io.sam.db.domain.Userinfo;
import io.sam.db.mapper.UserinfoMapper;
import io.sam.db.service.UserinfoService;
import io.sam.service.impl.OutServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
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

    @Autowired
    OutServiceImpl outService;
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
    @Transactional
    @Rollback(value = false)
    public void test002() throws Exception {
//        add();
        addAndUpdate();
    }

    @Test
    public void addAndUpdate() throws Exception {
        userinfoService.addAndUpdate();

    }

    public void update(Userinfo userinfo) throws Exception {
        userinfo.setName("更新"+userinfo.getName());
        userinfoMapper.updateByPrimaryKey(userinfo);
//        if (true){
//            throw new Exception("");
//        }
    }

//    @Transactional
    public void add(){
        Userinfo userinfo1 = userinfoMapper.selectByPrimaryKey(5010);
        log.info("USER:{}", JSON.toJSONString(userinfo1));
        Userinfo userinfo = new Userinfo();
        userinfo.setName("yyuyeh");
        userinfo.setAge(178);
        userinfoService.insertSelective(userinfo);
        userinfo1 = userinfoService.selectByPrimaryKey(5011);
        log.info("USER:{}", JSON.toJSONString(userinfo1));
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

    @Test
    public void testPropagation() throws Exception {
        outService.outM();
    }

    @Test
    public void testMandatoryPropagation() throws Exception {
        //外层不存在事务，则抛出异常
        outService.notTransactional();
    }

    @Test
    public void testMandatoryPropagation2() throws Exception {
        outService.hasTransactional();
    }
}
