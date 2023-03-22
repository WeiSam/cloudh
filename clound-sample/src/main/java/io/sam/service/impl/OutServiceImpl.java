package io.sam.service.impl;

import io.sam.db.domain.AccountTbl;
import io.sam.db.domain.Userinfo;
import io.sam.db.service.AccountTblService;
import io.sam.db.service.UserinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author zhuweimu
 * @description
 * @date 2022/10/17 14:23
 */
@Service
public class OutServiceImpl {

    @Autowired
    UserinfoService userinfoService;

    @Autowired
    InServiceImpl inService;

    @Transactional(rollbackFor = Exception.class)
    public void outM() throws Exception {
        Userinfo userinfo = new Userinfo()
                .setId(10000001)
                .setName("jkdjfks");
        userinfoService.insertSelective(userinfo);
        try {
            inService.inM(userinfo.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (false){
            throw new RuntimeException("外层事务异常");
        }
    }

    public void notTransactional() throws Exception {
        Userinfo userinfo = new Userinfo()
                .setId(10000001)
                .setName("jkdjfks");
        userinfoService.insertSelective(userinfo);
        inService.mandatory(userinfo.getId());
    }

    @Transactional(rollbackFor = Exception.class)
    public void hasTransactional() throws Exception {
        Userinfo userinfo = new Userinfo()
                .setId(10000001)
                .setName("jkdjfks");
        userinfoService.insertSelective(userinfo);
        inService.mandatory(userinfo.getId());
    }
}
