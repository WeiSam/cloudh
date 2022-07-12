package io.sam;

import io.sam.consistency.ConsistenceHash;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author zhuweimu
 * @description
 * @date 2022/7/12 11:20
 */
@Slf4j
public class ConsistenceHashTest {

    @Test
    void testConsistenceHash() {

        String key = "123abc";
        int count = 5;
        Map<String,Integer> map = new HashMap<>();
        for (int i = 0; i < count; i++) {
            ConsistenceHash.NodeInfo nodeInfo = ConsistenceHash.NodeInfo.builder()
                    .type(ConsistenceHash.NodeType.REAL)
                    .name("管理服务")
                    .key("192.168.78.1"+i)
                    .build();
            ConsistenceHash.addNode(nodeInfo);
        }

        for (int i = 1; i <= 3000; i++) {
            ConsistenceHash.NodeInfo nodeInfo = ConsistenceHash.getNodeInfo(UUID.randomUUID().toString());
            Integer num = map.computeIfAbsent(nodeInfo.getKey(), s -> 0);
            map.put(nodeInfo.getKey(),++num);
//            log.info("[{}]获取节点信息：{}",i, nodeInfo);
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            log.info("key:{},value:{}",entry.getKey(),entry.getValue());
        }

    }
}
