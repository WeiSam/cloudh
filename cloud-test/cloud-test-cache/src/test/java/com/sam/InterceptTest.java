package com.sam;

import com.alibaba.fastjson.JSON;
import io.sam.db.domain.TTest;
import io.sam.db.domain.TUser;
import io.sam.db.mapper.TTestMapper;
import io.sam.db.mapper.TUserMapper;
import io.sam.db.service.TUserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * @author zhuweimu
 * @description
 * @date 2023/4/10 11:34
 */
@Slf4j
public class InterceptTest extends BaseTest{

    @Autowired
    TUserService tUserService;

    @Autowired
    TUserMapper tUserMapper;

    @Autowired
    TTestMapper testMapper;

    @Test
    public void testQuery() {
        TUser tUser = tUserMapper.selectByPrimaryKey(1);
        log.info("{}", JSON.toJSONString(tUser));
    }

    @Test
    public void testInsert() {
        TUser tUser = new TUser()
                .setAge(11)
                .setClassName("就看见")
                .setCreateTime(new Date());
        tUserMapper.insertSelective(tUser);
        log.info("{}", JSON.toJSONString(tUser));
    }

    @Test
    public void testQuery1() {
        TTest tTest = testMapper.selectByPrimaryKey(1);
        log.info("{}", JSON.toJSONString(tTest));
    }
}
