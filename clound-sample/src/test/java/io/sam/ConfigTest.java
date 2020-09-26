package io.sam;

import io.sam.config.AutoConfig;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author zhuweimu
 * @classname ConfigTest
 * @description
 * @date 2020/9/18 16:40
 */
@Slf4j
public class ConfigTest extends BaseTest{

    @Autowired
    AutoConfig autoConfig;

    @Test
    public void testConfig(){
        log.info("autoConfig = {}", autoConfig.toString());
    }
}
