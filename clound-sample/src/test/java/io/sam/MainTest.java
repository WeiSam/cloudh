package io.sam;


import cn.hutool.bloomfilter.BitMapBloomFilter;
import com.alibaba.fastjson.JSON;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;
import io.sam.config.AutoConfig;
import io.sam.dto.UserDto;
import io.sam.service.TestFunctional;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.IOException;
import java.security.Key;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author zhuweimu
 * @Classname MainTest
 * @Description
 * @date 2020/9/7 9:31
 */
public class MainTest {

    SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

    @Test
    public void test01(){
        Key key = MacProvider.generateKey();
        String compactJws = Jwts.builder()
                .setSubject("Joe")
                .signWith(SignatureAlgorithm.HS256, key)
                .compact();

    }

    private static String CONDITION = "{0}='{1}'";
    private static String CONDITION2 = "%s='%s'";
    @Test
    public void test02(){
        StringJoiner stringJoiner = new StringJoiner(" AND ");
        Map<String,String> map = new HashMap<>();
        map.put("aa","12");
//        map.put("bb","34");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            stringJoiner.add(String.format(CONDITION2,entry.getKey(),entry.getValue()));
        }
        System.out.println(stringJoiner.toString());
        System.out.println(UUID.randomUUID().toString());
    }

    @Test
    public void testFunctional(){
        UserDto userDto = new UserDto();
        userDto.setName("123");
        System.out.println(getValue(userDto, JSON::toJSONString));
    }

    public String getValue(UserDto userDto,TestFunctional<UserDto,String> testFunctional){
        return testFunctional.test(userDto);
    }

    @Test
    public void testStream(){
        List<UserDto> userDtos = new ArrayList<>();
        Map<String, UserDto> userDtoMap = userDtos.stream().collect(Collectors.toMap(UserDto::getName, Function.identity()));
        System.out.println(userDtoMap);
    }

    @Test
    public void testBuLong() {
        BitMapBloomFilter filter = new BitMapBloomFilter(5);
        filter.add("82dc8474075834167b96aff7f78ade15");
        filter.add("82dc8474075834167b96aff7f78ade15");
        filter.add("82dc8474075834167b96aff7f78ade15");
        filter.add("82dc8474075834167b96aff7f78ade15");
        filter.add("82dc8474075834167b96aff7f78ade15");
        filter.add("82dc8474075834167b96aff7f78ade1511");
        int count = 0;
        for(;;count++){
            filter.add(UUID.randomUUID().toString());
            System.out.println(count);
            if (filter.contains("82dc8474075834167b96aff7f78ade1")) {
                System.out.println(count);
                return;
            }
        }
    }

    @Test
    public void testStringUtils() {

        String file = "F:\\文档资料\\对接文档\\..\\广西桂平执法监督平台对接\12.png";
        String path = StringUtils.cleanPath("application.yml");
        System.out.println(file);
        System.out.println(File.separator);
        System.out.println(File.separatorChar);
        System.out.println(StringUtils.unqualify(file, File.separatorChar));
        System.out.println(StringUtils.getFilename(file));
        String id = UUID.randomUUID().toString().replaceAll("-","");
        System.out.println(id);
        System.out.println();
        System.out.println(UUID.fromString("77f46f6a01c04090a84729169bd0dd2c"));


    }

    @Test
    public void testClassPathResource() throws IOException {
        ClassPathResource classPathResource = new ClassPathResource("application.yml");
        System.out.println(classPathResource.getPath());
        Properties properties = PropertiesLoaderUtils.loadProperties(classPathResource);
        System.out.println(properties.getProperty("test.name"));

        AnnotationMetadata annotationMetadata = AnnotationMetadata.introspect(AutoConfig.class);
        System.out.println(annotationMetadata.getClassName());
        annotationMetadata.getAnnotationTypes().stream().forEach(System.out::println);
//        ConditionEvaluator conditionEvaluator = new ConditionEvaluator(registry, environment, resourceLoader);
    }

    @Test
    public void testRemove() {
        Set<String> set = new HashSet<>();
        set.add("72864372hjvsjkdhjf");
        set.add("aksjcnlsdjfjshfkkjslkd");
        set.add("ksjdkjskdjksjdkjskf");

        for (String id : set) {
            System.out.println(id);
            set.remove(null);
//            set.removeIf("aksjcnlsdjfjshfkkjslkd"::equals);
        }
        set.add("111111");

//        set.forEach(System.out::println);
    }

    @Test
    public void testCopyOnWriteArrayList() {
        ArrayList<String> list = null;
        CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        copyOnWriteArrayList.add("12");

        Integer aa = -Math.abs(-1);

    }

    @Test
    public void testSort() {
        HashMap<String, UserDto> map = new HashMap<>();
        map.put("user1",new UserDto().setAge(18));
        map.put("user2",new UserDto().setAge(19));
        map.put("user3",new UserDto().setAge(20));
        map.put("user4",new UserDto().setAge(21));
        map.put("user5",new UserDto().setAge(20));
        map.put("user6",new UserDto().setAge(23));
        map.values().stream()
                .sorted(Comparator.comparingInt(UserDto::getAge))
                .forEach(userDto -> System.out.println(userDto.getAge()));
    }
}

