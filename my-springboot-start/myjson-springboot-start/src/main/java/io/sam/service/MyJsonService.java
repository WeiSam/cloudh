package io.sam.service;

import com.alibaba.fastjson.JSON;

/**
 * @author zhuweimu
 * @Classname MyJsonService
 * @Description
 * @date 2020/8/24 8:35
 */
public class MyJsonService {

    private String prefixName;

    public String toJsonString(Object obj){
        return prefixName+":"+JSON.toJSONString(obj);
    }

    public String getPrefixName() {
        return prefixName;
    }

    public void setPrefixName(String prefixName) {
        this.prefixName = prefixName;
    }
}
