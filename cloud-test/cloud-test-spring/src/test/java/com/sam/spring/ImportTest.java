package com.sam.spring;

import com.alibaba.fastjson.JSON;
import com.sam.BaseTest;
import io.sam.bean.UserBean;
import io.sam.config.TestImportConfig;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author zhuweimu
 * @description
 * @date 2021/6/16 16:10
 */
@Slf4j
public class ImportTest extends BaseTest {

    @Autowired
    TestImportConfig testImportConfig;

    @Autowired
    UserBean userBean;

    @Test
    public void testImport() {
//        log.info(JSON.toJSONString(testImportConfig));
        log.info(JSON.toJSONString(userBean));
    }
}
