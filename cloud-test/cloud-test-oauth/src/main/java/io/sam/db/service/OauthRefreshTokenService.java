package io.sam.db.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import io.sam.db.mapper.OauthRefreshTokenMapper;
/**
 * @description 
 * @date 2021/4/29 14:45
 * @author zhuweimu
 */
@Service
public class OauthRefreshTokenService{

    @Resource
    private OauthRefreshTokenMapper oauthRefreshTokenMapper;

}
