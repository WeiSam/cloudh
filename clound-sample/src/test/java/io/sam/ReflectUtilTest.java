package io.sam;

import cn.hutool.core.bean.BeanDesc;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ReflectUtil;
import com.alibaba.fastjson.JSON;
import io.sam.cache.TokenCache;
import io.sam.constant.MQContants;
import io.sam.db.domain.QbBaqry;
import io.sam.dto.GetEnclosingClassOfClass;
import io.sam.dto.UserDto;
import io.sam.service.LogService;
import io.sam.service.impl.DataLogServiceImpl;
import io.sam.service.impl.LockTestServiceImpl;
import io.sam.utils.DictionaryUtils;
import io.sam.utils.QuanZhouPopulationConfig;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.util.StopWatch;
import org.springframework.util.StringUtils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Date;
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
        Thread.sleep(1000*5);
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

            token = tokenCache.put(key,() -> UUID.randomUUID().toString());
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

    @Test
    public void getStatic() throws IllegalAccessException {
        Field[] fields = ReflectUtil.getFields(MQContants.class);
        for (Field field : fields) {
            if (Modifier.isStatic(field.getModifiers()) && field.getName().contains("LEAVE")
                    && String.class.getName().equals(field.getType().getName())) {
//                String value = (String) ReflectUtil.getStaticFieldValue(field);
                String value = (String) field.get(null);
                System.out.println(value);
            }
        }
    }

    @Test
    public void testX() throws Exception {
        StopWatch stopWatch = new StopWatch();
        int count = 10000000;
        QbBaqry qbBaqry = new QbBaqry();

        Class<QbBaqry> qbBaqryClass = QbBaqry.class;
        QbBaqry qbBaqry1 = qbBaqryClass.newInstance();

        Long start = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            new QbBaqry();
        }
        Long end = System.currentTimeMillis();
        log.info("正常创建耗时：{} ms",end - start);

        start = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            qbBaqryClass.newInstance();
        }
        end = System.currentTimeMillis();
        log.info("Class创建耗时：{} ms",end - start);

       /* start = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            Class.forName("io.sam.db.domain.QbBaqry").newInstance();
        }
        end = System.currentTimeMillis();
        log.info("forName创建耗时：{} ms",end - start);*/

        start = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            qbBaqry1.setAjbh("");
            qbBaqry1.setRybh("");
            qbBaqry1.setXm("");
            qbBaqry1.setSfzh("");
            qbBaqry1.setRssj(new Date());
            qbBaqry1.setLssj(new Date());
            qbBaqry1.setRygj("");
            qbBaqry1.setSfcj("");
            qbBaqry1.setSfstjc("");
            qbBaqry1.setSswp("");
            qbBaqry1.setQcsp("");
            qbBaqry1.setCbdwBh("");
            qbBaqry1.setCbrSfzh("");
            qbBaqry1.setSfcjdz("");
            qbBaqry1.setSfstjcdz("");
        }
        end = System.currentTimeMillis();
        log.info("反射对象执行耗时：{} ms",end - start);

        start = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            qbBaqry.setAjbh("");
            qbBaqry.setRybh("");
            qbBaqry.setXm("");
            qbBaqry.setSfzh("");
            qbBaqry.setRssj(new Date());
            qbBaqry.setLssj(new Date());
            qbBaqry.setRygj("");
            qbBaqry.setSfcj("");
            qbBaqry.setSfstjc("");
            qbBaqry.setSswp("");
            qbBaqry.setQcsp("");
            qbBaqry.setCbdwBh("");
            qbBaqry.setCbrSfzh("");
            qbBaqry.setSfcjdz("");
            qbBaqry.setSfstjcdz("");
        }
        end = System.currentTimeMillis();
        log.info("正常执行耗时：{} ms",end - start);

        stopWatch.start("1");
        Thread.sleep(100);
        stopWatch.stop();
        System.out.println(stopWatch.getTotalTimeMillis());

        stopWatch.start("2");
        Thread.sleep(200);
        stopWatch.stop();
        System.out.println(stopWatch.getTaskInfo()[1].getTimeMillis());
    }

    @Test
    public void reflect() throws Exception {
        Thread.currentThread().setName("fanshe-test");
        int i = 1;
        while (true){
            UserDto userDto = UserDto.class.newInstance();
            userDto.setName("sam"+i++);
        }

    }

    @Test
    public void reflect02() throws Exception {
        Thread.currentThread().setName("fanshe-test01");
        int i = 1;
        for (int j = 0; j <10000; j++) {
            new Thread(new Runnable() {
                @SneakyThrows
                @Override
                public void run() {
                    UserDto userDto = UserDto.class.newInstance();
                    userDto.setName("sam");
                }
            }).start();

        }
    }

    @Test
    public void put() throws Exception {
        QuanZhouPopulationConfig populationConfig = new QuanZhouPopulationConfig();
        DictionaryUtils.getDicFieldValue(populationConfig);
        System.out.println(JSON.toJSONString(populationConfig.getDicConfigMap()));
    }

    @Test
    public void testStopWatch() throws InterruptedException {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Thread.sleep(100);
        stopWatch.stop();
        log.info("getLastTaskTimeMillis:{}",stopWatch.getLastTaskTimeMillis());
        stopWatch.start("2");
        Thread.sleep(200);
        stopWatch.stop();
        log.info("getLastTaskTimeMillis:{}",stopWatch.getLastTaskTimeMillis());
        Thread.sleep(100);
        log.info("1:{},2:{},all:{}",stopWatch.getTaskInfo()[0].getTimeMillis(),stopWatch.getTaskInfo()[1].getTimeMillis(),stopWatch.getTotalTimeMillis());

    }
}
