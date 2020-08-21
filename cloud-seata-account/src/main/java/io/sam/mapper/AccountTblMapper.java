package io.sam.mapper;

import io.sam.domain.AccountTbl;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AccountTblMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AccountTbl record);

    int insertSelective(AccountTbl record);

    AccountTbl selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AccountTbl record);

    int updateByPrimaryKey(AccountTbl record);

    void reduce(@Param("userId") String userId, @Param("money") int money);
}