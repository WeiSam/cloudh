package io.sam.service;

import io.sam.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

/**
 * @author zhuweimu
 * @classname RestTemplateTest
 * @description
 * @date 2020/12/9 19:05
 */
public class RestTemplateTest extends BaseTest {

    @Autowired
    RestTemplate restTemplate;

    @Test
    public void testRest() {
        String s = restTemplate.postForObject("http://127.0.0.1:1111/getTem", "", String.class);
        System.out.println(s);
    }
}
