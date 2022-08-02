package io.sam.db.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.sam.db.domain.Userinfo;import org.apache.ibatis.annotations.Param;import java.util.List;

/**
 * @author zhuweimu
 * @description
 * @date 2022/2/25 9:20
 */
public interface UserinfoMapper extends BaseMapper<Userinfo> {
    int deleteByPrimaryKey(Integer id);

    int insert(Userinfo record);

    int insertSelective(Userinfo record);

    Userinfo selectByPrimaryKey(Integer id);

    Userinfo selectAge(Integer age);

    int updateByPrimaryKeySelective(Userinfo record);

    int updateByPrimaryKey(Userinfo record);

    int batchInsert(@Param("userinfos") List<Userinfo> userinfos);
}