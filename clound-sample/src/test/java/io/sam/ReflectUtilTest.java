package io.sam;

import cn.hutool.core.bean.BeanDesc;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ReflectUtil;
import com.alibaba.fastjson.JSON;
import io.sam.cache.TokenCache;
import io.sam.dto.GetEnclosingClassOfClass;
import io.sam.dto.UserDto;
import io.sam.service.LogService;
import io.sam.service.impl.DataLogServiceImpl;
import io.sam.service.impl.LockTestServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.util.StringUtils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.UUID;

/**
 * @author zhuweimu
 * @classname ReflectUtilTest
 * @description
 * @date 2020/10/13 9:49
 */
@Slf4j
public class ReflectUtilTest {

    @Test
    public void testReflectUtil() throws IllegalAccessException, InstantiationException {

        UserDto userDto = ReflectUtil.newInstance(UserDto.class);
        BeanDesc beanDesc = BeanUtil.getBeanDesc(UserDto.class);
        Constructor<?>[] constructors = UserDto.class.getConstructors();
        UserDto userDto1 = UserDto.class.newInstance();
    }

    static final TokenCache<String,String> tokenCache = new TokenCache<String,String>();

    @Test
    public void testModifier() {
        log.info("Modifiers = {},isInterface = {}",LogService.class.getModifiers(),Modifier.isInterface(LogService.class.getModifiers()));
        log.info("Modifiers = {},isInterface = {}",DataLogServiceImpl.class.getModifiers(),Modifier.isInterface(DataLogServiceImpl.class.getModifiers()));
        log.info("Modifiers = {},isInterface = {}",LockTestServiceImpl.class.getModifiers(),Modifier.isInterface(LockTestServiceImpl.class.getModifiers()));
        log.info("{}",Modifier.methodModifiers());

        Method[] methods = LogService.class.getMethods();
        System.out.println(methods[0].getClass());
        System.out.println(methods[0].getClass().getModifiers());
        System.out.println(methods[0].getModifiers());
        log.info("{}",Modifier.isAbstract(methods[0].getModifiers()));
        System.out.println(GetEnclosingClassOfClass.InnerClass02.class.getDeclaringClass());
    }

    @Test
    public void testLock() throws InterruptedException {
        for (int i=0;i<1000;i++){
            new Thread(() -> {
                log.info("token = {}",getToken02("123"));
            }).start();
        }
        Thread.sleep(1000*100);
        System.out.println(JSON.toJSONString(tokenCache.getCache()));
    }

    String getToken(String key){
        String token = tokenCache.get(key);
        if (StringUtils.isEmpty(token)) {
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            token = UUID.randomUUID().toString();
            tokenCache.put(key,token);
        }
        return token;
    }

    String getToken02(String key){
        String token = tokenCache.getCache().get(key);
        if (!StringUtils.isEmpty(token)) {
            return token;
        }
        synchronized (ReflectUtilTest.class){
            token = tokenCache.getCache().get(key);
            if (!StringUtils.isEmpty(token)) {
                return token;
            }
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            token = UUID.randomUUID().toString();
            tokenCache.getCache().put(key,token);
        }
        return token;
    }

}
