package com.sam.spring;

import com.alibaba.fastjson.JSON;
import io.sam.CloudTestSpring;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author zhuweimu
 * @description
 * @date 2022/10/25 9:10
 */
@Slf4j
public class AnnotationMetadataTest {

    @Test
    void testAnnotationMetadata() {
        AnnotationMetadata metadata = AnnotationMetadata.introspect(CloudTestSpring.class);
        log.info(JSON.toJSONString(metadata));
    }
}
