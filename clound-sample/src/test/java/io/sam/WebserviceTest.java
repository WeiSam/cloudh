package io.sam;

import io.sam.webservice.jdk.TraditionalSimplifiedWebService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author zhuweimu
 * @desc
 * @date 2021/6/2 15:18
 */
@Slf4j
public class WebserviceTest {

    @Test
    public void testWebService() {
        TraditionalSimplifiedWebService traditionalSimplifiedWebService = new TraditionalSimplifiedWebService();
        String chinese = traditionalSimplifiedWebService.getTraditionalSimplifiedWebServiceSoap().toTraditionalChinese("吉安市打耳洞付货款收到回复绝对是空间");
        log.info(chinese);
    }
}
