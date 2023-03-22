package com.sam.service;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.conditions.query.QueryChainWrapper;
import com.sam.BaseTest;
import io.sam.db.domain.Userinfo;
import io.sam.db.mapper.UserinfoMapper;
import io.sam.db.service.UserinfoService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author zhuweimu
 * @description
 * @date 2021/9/6 15:41
 */
@Slf4j
public class UserinfoServiceTest extends BaseTest {

    @Autowired
    UserinfoMapper userinfoMapper;

    @Autowired
    UserinfoService userinfoService;

    @Test
    public void test01() {
//        List<Userinfo> userinfos = userinfoService.list();
//        log.info("{}", JSON.toJSONString(userinfos));
        List<Userinfo> userinfos1 = userinfoService.list(new QueryWrapper<Userinfo>().eq("id", 5011));
        log.info(JSON.toJSONString(userinfoService.getById(85011)));
    }

    @Test
    public void test02() {
    }

    @Test
    public void test002() {
        add();
    }

    @Transactional
    public void add(){
        Userinfo userinfo1 = userinfoMapper.selectById(85011);
        log.info("USER:{}", JSON.toJSONString(userinfo1));
        Userinfo userinfo = new Userinfo();
        userinfo.setName("yyuyeh");
        userinfo.setAge(178);
        userinfoService.save(userinfo);
        userinfo1 = userinfoMapper.selectById(85012);
        log.info("USER:{}", JSON.toJSONString(userinfo1));
    }

}
