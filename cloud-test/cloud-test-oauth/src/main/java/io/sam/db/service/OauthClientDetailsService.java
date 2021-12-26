package io.sam.db.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import io.sam.db.mapper.OauthClientDetailsMapper;
/**
 * @description 
 * @date 2021/4/29 14:45
 * @author zhuweimu
 */
@Service
public class OauthClientDetailsService{

    @Resource
    private OauthClientDetailsMapper oauthClientDetailsMapper;

}
