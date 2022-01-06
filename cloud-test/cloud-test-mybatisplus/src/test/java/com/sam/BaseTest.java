package com.sam;

import io.sam.CloudTestMybatisPlus;
import lombok.extern.slf4j.Slf4j;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author zhuweimu
 * @classname BaseTest
 * @description
 * @date 2020/9/18 16:40
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = CloudTestMybatisPlus.class)
public class BaseTest {
}
