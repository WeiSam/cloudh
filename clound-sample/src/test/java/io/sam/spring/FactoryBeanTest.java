package io.sam.spring;

import com.alibaba.fastjson.JSON;
import io.sam.BaseTest;
import io.sam.annotation.MyMapper;
import io.sam.config.MyMapperAutoConfig;
import io.sam.dto.UserDto;
import io.sam.service.impl.SqlLogServiceImpl;
import io.sam.service.impl.TestMyMapperServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.mybatis.spring.mapper.ClassPathMapperScanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author zhuweimu
 * @classname FactoryBeanTest
 * @description
 * @date 2020/10/27 11:38
 */
@Slf4j
public class FactoryBeanTest extends BaseTest {

    @Autowired(required = false)
    UserDto userDto;

    @Test
    public void testFactoryBean() {
        log.info("userDto = {}", JSON.toJSONString(userDto));
    }

    @Autowired
    MyMapperAutoConfig myMapperAutoConfig;

    @Autowired(required = false)
    TestMyMapperServiceImpl myMapperService;

    @Test
    public void testImport() {
        System.out.println(myMapperAutoConfig.getName());
        log.info("userDto = {}", JSON.toJSONString(userDto));
        log.info("{}",myMapperService.getClassName());
    }

    @Test
    public void testScan() {
        AnnotationConfigApplicationContext registry = new AnnotationConfigApplicationContext();
        ClassPathMapperScanner scanner = new ClassPathMapperScanner(registry);
//        scanner.setResourceLoader(AnnotationConfigApplicationContext.class.getClassLoader());
        scanner.setAnnotationClass(MyMapper.class);
        scanner.registerFilters();
        scanner.doScan(new String[]{"io.sam.service"});
    }


    @Autowired
    SqlLogServiceImpl sqlLogService;

    @Test
    public void testPrototypeScopeBean() {
        for (int i=0;i<5;i++)
            sqlLogService.print();
    }
}
