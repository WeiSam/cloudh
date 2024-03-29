package io.sam.db.service;

import io.sam.db.domain.AccountTbl;
import io.sam.db.mapper.AccountTblMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
/**
 * @classname AccountTblService
 * @description 
 * @date 2020/10/27 14:32
 * @author zhuweimu
 */
@Slf4j
@Service
public class AccountTblService{

    @Autowired
    private AccountTblMapper accountTblMapper;

    @Autowired
    AccountTblService accountTblService;

    @Cacheable
    public int deleteByPrimaryKey(Integer id) {
        return accountTblMapper.deleteByPrimaryKey(id);
    }

    
    public int insert(AccountTbl record) {
        return accountTblMapper.insert(record);
    }

    
    public int insertSelective(AccountTbl record) {
        return accountTblMapper.insertSelective(record);
    }

    @Cacheable(value = "Acount",key = "#id",unless = "#result == null ")
    public AccountTbl selectByPrimaryKey(Integer id) {
        return selectByPrimaryKeyNotCache(id);
    }

    public AccountTbl selectByPrimaryKeyNotCache(Integer id) {
        log.info("查询数据库");
        if (id == 1) {
            return null;
        }
        return new AccountTbl();
    }

    
    public int updateByPrimaryKeySelective(AccountTbl record) {
        return accountTblMapper.updateByPrimaryKeySelective(record);
    }

    
    public int updateByPrimaryKey(AccountTbl record) {
        return accountTblMapper.updateByPrimaryKey(record);
    }

}
