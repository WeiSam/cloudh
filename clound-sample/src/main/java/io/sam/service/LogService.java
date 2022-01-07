package io.sam.service;

import io.sam.annotation.DisLock;

/**
 * @author zhuweimu
 * @classname LogService
 * @description
 * @date 2020/9/21 9:48
 */
public interface LogService {

    void print();

    default void print(String data){
        System.out.println(data);
    }
}
