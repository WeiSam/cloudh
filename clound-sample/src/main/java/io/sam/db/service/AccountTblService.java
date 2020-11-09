package io.sam.db.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import io.sam.db.mapper.AccountTblMapper;
import io.sam.db.domain.AccountTbl;
/**
 * @classname AccountTblService
 * @description 
 * @date 2020/10/27 14:32
 * @author zhuweimu
 */
@Service
public class AccountTblService{

    @Resource
    private AccountTblMapper accountTblMapper;

    
    public int deleteByPrimaryKey(Integer id) {
        return accountTblMapper.deleteByPrimaryKey(id);
    }

    
    public int insert(AccountTbl record) {
        return accountTblMapper.insert(record);
    }

    
    public int insertSelective(AccountTbl record) {
        return accountTblMapper.insertSelective(record);
    }

    
    public AccountTbl selectByPrimaryKey(Integer id) {
        return accountTblMapper.selectByPrimaryKey(id);
    }

    
    public int updateByPrimaryKeySelective(AccountTbl record) {
        return accountTblMapper.updateByPrimaryKeySelective(record);
    }

    
    public int updateByPrimaryKey(AccountTbl record) {
        return accountTblMapper.updateByPrimaryKey(record);
    }

}
