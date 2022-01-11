package io.sam;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

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
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < 10000; i++) {
            long l = snowflake.nextId();
            set.add(String.valueOf(l).length());
        }

        System.out.println(set.size());
    }
}
