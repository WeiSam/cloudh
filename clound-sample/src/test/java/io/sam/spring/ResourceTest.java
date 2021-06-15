package io.sam.spring;

import com.alibaba.fastjson.JSON;
import io.sam.dto.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.core.io.ClassRelativeResourceLoader;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;

/**
 * @author zhuweimu
 * @description
 * @date 2021/5/17 14:08
 */
@Slf4j
public class ResourceTest {

    @Test
    public void testClassRelativeResourceLoader() {
        ClassRelativeResourceLoader classRelativeResourceLoader = new ClassRelativeResourceLoader(UserDto.class);
        classRelativeResourceLoader.getResource("");
    }

    @Test
    public void testDefaultResourceLoader() {
        DefaultResourceLoader defaultResourceLoader = new DefaultResourceLoader();
        Resource resource = defaultResourceLoader.getResource("classpath:io/sam/dto/UserDto.class");
        String filename = resource.getFilename();
        log.info("{}", JSON.toJSONString(resource));
    }
}
