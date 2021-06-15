package io.sam.spring;

import com.alibaba.fastjson.JSON;
import io.sam.BaseTest;
import io.sam.dto.UserDto;
import io.sam.service.MyMapperNameTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author zhuweimu
 * @classname MyMapperTest
 * @description
 * @date 2020/11/9 16:54
 */
@Slf4j
public class MyMapperTest extends BaseTest {

    @Autowired
    MyMapperNameTest myMapperNameTest;

    @Test
    public void testMyMapper() throws IOException {
        byte[] bytes = ProxyGenerator.generateProxyClass("$MyMapperProxy@2eb03908", new Class[]{MyMapperNameTest.class});
        FileOutputStream os = new FileOutputStream("F://$MyMapperNameTest.class");
        os.write(bytes);
        os.close();
        System.out.println(myMapperNameTest.age());
    }

    @Qualifier("userDtoInstanceSupplier")
    @Autowired
    UserDto userDto;

    @Test
    public void testInstanceSupplier() {
        log.info(JSON.toJSONString(userDto));
    }

    @Autowired
    Properties properties;

    @Test
    public void testProperties() {
        log.info(JSON.toJSONString(properties));
    }
}
