package io.sam;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import org.junit.Test;

/**
 * @author zhuweimu
 * @classname DistributIdTest
 * @description 分布式id生成
 * @date 2020/11/24 9:26
 */
public class DistributIdTest {

    Snowflake snowflake = IdUtil.getSnowflake(1,2);
    @Test
    public void snId() {
        long l = snowflake.nextId();
        System.out.println(l);
    }
}
