package io.sam.shardingphere;

import com.alibaba.fastjson.JSON;
import io.sam.BaseTest;
import io.sam.db.domain.Userinfo;
import io.sam.db.service.UserinfoService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.event.annotation.BeforeTestExecution;
import org.springframework.test.context.event.annotation.BeforeTestMethod;

/**
 * @author zhuweimu
 * @description
 * @date 2021/7/20 17:34
 */
@Slf4j
public class EncryptRuleTest extends BaseTest {

    @Autowired
    UserinfoService userinfoService;

    @Test
    public void testEncryptRule() {
        Userinfo userinfo = userinfoService.selectByPrimaryKey(1);
        log.info("{}", JSON.toJSONString(userinfo));
    }

    @BeforeTestMethod
    public void insertUser() {
        userinfoService.insertSelective(new Userinfo()
                .setName("哈哈哈"));
    }
}
