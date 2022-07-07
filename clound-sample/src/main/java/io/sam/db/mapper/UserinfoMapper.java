package io.sam.db.mapper;

import io.sam.db.domain.Userinfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author zhuweimu
 * @description
 * @date 2021/8/30 9:18
 */
@Mapper
public interface UserinfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Userinfo record);

    int insertSelective(Userinfo record);

    Userinfo selectByPrimaryKey(Integer id);
    Userinfo selectAge(Integer age);

    int updateByPrimaryKeySelective(Userinfo record);

    int updateByPrimaryKey(Userinfo record);

    int batchInsert(@Param("userinfos") List<Userinfo> userinfos);
}