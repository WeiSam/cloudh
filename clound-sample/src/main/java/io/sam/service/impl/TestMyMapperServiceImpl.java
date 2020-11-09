package io.sam.service.impl;

import io.sam.annotation.MyMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author zhuweimu
 * @classname TestMyMapperServiceImpl
 * @description
 * @date 2020/10/28 15:26
 */
@MyMapper
public class TestMyMapperServiceImpl {

    @Autowired
    PrototypeServiceImpl prototypeService;

    public String getClassName(){
        return this.getClass().getName();
    }
}
