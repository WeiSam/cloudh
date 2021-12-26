package io.sam.service.impl;

import io.sam.constant.MQContants;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * @author zhuweimu
 * @classname PrototypeServiceImpl
 * @description
 * @date 2020/11/2 11:40
 */
@Scope(scopeName = "prototype")
@Service
public class PrototypeServiceImpl {

    public String getName(){
        System.out.println("PrototypeServiceImpl");
        return PrototypeServiceImpl.class.getName();
    }
}
