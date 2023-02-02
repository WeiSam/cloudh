package io.sam.service.impl;

import io.sam.db.domain.AccountTbl;
import io.sam.db.service.AccountTblService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author zhuweimu
 * @description
 * @date 2022/10/17 14:23
 */
@Service
public class InServiceImpl {

    @Autowired
    AccountTblService accountTblService;

    @Transactional(propagation = Propagation.NESTED,rollbackFor = Exception.class)
    public void inM(Integer userId) throws Exception {
        AccountTbl accountTbl = new AccountTbl().setId(userId).setMoney(1000);
        accountTblService.insert(accountTbl);
        if (true){
            throw new RuntimeException("内层事务异常");
        }
    }
}
