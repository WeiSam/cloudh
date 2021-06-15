package io.sam.db.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import io.sam.db.mapper.OauthCodeMapper;
/**
 * @description 
 * @date 2021/4/29 14:45
 * @author zhuweimu
 */
@Service
public class OauthCodeService{

    @Resource
    private OauthCodeMapper oauthCodeMapper;

}
