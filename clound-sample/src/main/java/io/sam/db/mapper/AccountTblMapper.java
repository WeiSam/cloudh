package io.sam.db.mapper;

import io.sam.db.domain.AccountTbl;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.transaction.annotation.Transactional;

/**
 * @classname AccountTblMapper
 * @description 
 * @date 2020/10/27 14:32
 * @author zhuweimu
 */
@Mapper
public interface AccountTblMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AccountTbl record);

    int insertSelective(AccountTbl record);

    @Transactional
    AccountTbl selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AccountTbl record);

    int updateByPrimaryKey(AccountTbl record);
}