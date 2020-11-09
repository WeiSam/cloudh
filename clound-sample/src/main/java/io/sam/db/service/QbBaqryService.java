package io.sam.db.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import io.sam.db.mapper.QbBaqryMapper;
import io.sam.db.domain.QbBaqry;
/**
 * @classname QbBaqryService
 * @description 
 * @date 2020/11/5 15:12
 * @author zhuweimu
 */
@Service
public class QbBaqryService{

    @Resource
    private QbBaqryMapper qbBaqryMapper;

    
    public int insert(QbBaqry record) {
        return qbBaqryMapper.insert(record);
    }

    
    public int insertSelective(QbBaqry record) {
        return qbBaqryMapper.insertSelective(record);
    }

}
