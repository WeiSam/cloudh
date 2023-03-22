package io.sam.service;

import io.sam.BaseTest;
import io.sam.db.domain.Userinfo;
import io.sam.db.mapper.UserinfoMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StopWatch;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhuweimu
 * @description
 * @date 2021/9/10 9:26
 */
@Slf4j
public class TestMybatisService extends BaseTest {

    @Autowired
    SqlSessionFactory sqlSessionFactory;

    @Autowired
    UserinfoMapper userinfoMapper;

    @Test
    public void testBatch() {
        List<Userinfo> list = new ArrayList<>();
        int count = 20000;
        
        for (int i = 1; i <= count; i++) {
            list.add(new Userinfo()
                    .setName("Dean"+i)
                    .setAge(i));
        }
        StopWatch stopWatch = new StopWatch();
        SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH,false);
        UserinfoMapper userinfoMapper = sqlSession.getMapper(UserinfoMapper.class);
        stopWatch.start("批量处理");
        list.forEach(userinfoMapper::insertSelective);
        sqlSession.commit();
        sqlSession.close();
        stopWatch.stop();

        System.out.println("getLastTaskTimeMillis: "+stopWatch.getLastTaskTimeMillis());
        stopWatch.start("xml拼接");
        int insertCount = this.userinfoMapper.batchInsert(list);
        stopWatch.stop();
        System.out.println("getLastTaskTimeMillis: "+stopWatch.getLastTaskTimeMillis());
        log.info("批量处理耗时:{}",stopWatch.getTaskInfo()[0].getTimeMillis());
        log.info("xml拼接处理,count = {},耗时:{}",insertCount,stopWatch.getTaskInfo()[1].getTimeMillis());

    }
}
