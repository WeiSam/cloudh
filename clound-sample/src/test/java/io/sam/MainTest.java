package io.sam;
import cn.hutool.bloomfilter.BitMapBloomFilter;
import cn.hutool.core.util.ReflectUtil;
import cn.hutool.crypto.digest.MD5;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.ValueFilter;
import eunms.EnumPaymentType;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;
import io.sam.config.AutoConfig;
import io.sam.dto.Derived;
import io.sam.dto.UserDto;
import io.sam.dto.YanTaiRepositoryResp;
import io.sam.enums.OderType;
import io.sam.service.TestFunctional;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.DateUtil;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.security.Key;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * @author zhuweimu
 * @Classname MainTest
 * @Description
 * @date 2020/9/7 9:31
 */
@Slf4j
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
    public void testCopyOnWriteArrayList() throws Exception {
        ArrayList<String> list = null;
        CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        copyOnWriteArrayList.add("12");

        Integer i = 1;
        YanTaiRepositoryResp yanTaiRepositoryResp = new YanTaiRepositoryResp();
        yanTaiRepositoryResp.setResults(new ArrayList<>());
        Integer weikon = Optional.ofNullable(yanTaiRepositoryResp)
                .map(YanTaiRepositoryResp::getResults)
                .filter(ss -> !CollectionUtils.isEmpty(ss))
                .map(repositoryInfos -> repositoryInfos.get(0))
                .map(YanTaiRepositoryResp.RepositoryInfo::getIid)
                .orElseThrow(() -> new Exception("weikon"));

        Optional<List<YanTaiRepositoryResp.RepositoryInfo>> repositoryInfos = Optional.ofNullable(yanTaiRepositoryResp)
                .map(YanTaiRepositoryResp::getResults);

        System.out.println(repositoryInfos.isPresent());



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

    @Test
    public void jsonStr() {
        UserDto userDto = new UserDto();
        String s = jsonNullToStr(userDto);
        UserDto userDto1 = JSON.parseObject(s, UserDto.class);
        System.out.println(JSON.toJSONString(null));
        System.out.println("123ghjdf".substring(0,1));
    }

    public static String jsonNullToStr(Object obj){
        return JSON.toJSONString(obj, (ValueFilter)(object, name, value) ->{
            if (value == null) {
                Field field = ReflectUtil.getField(object.getClass(), name);
                if (String.class.getName().equals(field.getGenericType().getTypeName())) {
                    return "";
                }
                return "";
            }
            return value;
        });
    }

    @Test
    public void testFather() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date1 = sdf.parse("2020-12-19 12:30:01");
        Derived d = new Derived();
        Date date2 = sdf.parse("2020-12-19 12:30:00");
        System.out.println(date1.equals(date2));
        System.out.println( d.whenAmISet );
    }

    @Test
    public void testEx() {

        try {
            for (int i=0;i<2;i++){
                try {
                    if (i==1){
                        continue;
                    }
                    System.out.println("jkdj");
                }catch (Exception e){
                }finally {
                    System.out.println("执行0000");
                }

            }
        }catch (Error er){
            System.out.println("Error");
        }catch (RuntimeException re){
            System.out.println("RuntimeException");
        }catch (Exception e){
            System.out.println("Exception");
        }catch (Throwable t){

        }finally {
//            System.out.println("执行了");
        }
    }

    @Test
    public void sort() throws InterruptedException {
        List<UserDto> list = new ArrayList();
        UserDto userDto = new UserDto().setName("sam").setBirth(DateUtil.parse("2020-12-19"));
        UserDto userDto1 = new UserDto().setName("sam1").setBirth(DateUtil.parse("2020-12-10"));
        UserDto userDto2 = new UserDto().setName("sam2").setBirth(DateUtil.parse("2020-12-10"));
        UserDto userDto3 = new UserDto().setName("sam3").setBirth(DateUtil.parse("2020-12-02"));
        UserDto userDto4 = new UserDto().setName("sam4").setBirth(DateUtil.parse("2020-12-09"));
        UserDto userDto5 = new UserDto().setName("sam5");
        list.add(userDto1);
        list.add(userDto);
        list.add(userDto2.setAge(11));
        list.add(userDto4);
        list.add(userDto3);
        list.add(userDto4);
        list.add(userDto4);
        list.add(userDto5);
        List<UserDto> sort = list.stream()
                .sorted(Comparator.nullsLast(Comparator.comparing(UserDto::getBirth).thenComparing(UserDto::getAge)))
                .collect(Collectors.toList());
        sort.stream().forEach(System.out::println);
    }

    @Test
    public void testE() {
        log.error("fdfd:{}",JSON.toJSONString(null));
        EnumPaymentType paypal = EnumPaymentType.PAYPAL;
        System.out.println(paypal.name());
        System.out.println(paypal.getName());
        System.out.println(OderType.ONE.name());
        System.out.println("0".equals(null));
        ThreadLocalRandom current = ThreadLocalRandom.current();
        for (int i = 0; i < 10; i++) {
            System.out.println(current.nextInt(1,10));
        }

    }

    private static final int COUNT_BITS = Integer.SIZE - 3;
    private static final int CAPACITY   = (1 << COUNT_BITS) - 1;
    private static final int NCAPACITY = ~CAPACITY;
    @Test
    public void name() {
        System.out.println(COUNT_BITS);
        System.out.println(CAPACITY);
        System.out.println(~1);
        System.out.println(~2);
        String str = new String("11111110");
        String str1 = "11111110";
        System.out.println(11111110);
        System.out.println(str == str1);
        System.out.println(Objects.equals(str,str1));

        System.out.println(Optional.ofNullable("").orElse("hjsd"));
    }

    private final static String C1 = "!\\[CDATA\\[";
    private final static String C2 = "]]";

    @Test
    public void test6() {
        StringBuffer conditionSql = new StringBuffer("&lt;![CDATA[62&lt;5175]]&gt;");
        System.out.println(C1);
        String str = "{casecenter}:{QUERYALL}:{管理员}:{查询嫌疑人}:{{\"isDeleted\":\"N\",\"leaveTimeEnd\":\"2021-06-09 23:59:59\",\"leaveTimeStart\":\"2021-06-09 00:00:00\",\"orgMagicId\":\"2e5e51a3d361b66971bbf7d2bd637fd0\"}}";
        System.out.println(String.format("%s",conditionSql.toString()
                .replaceAll("&lt;"+C1,"<"+C1)
                .replaceAll(C2+"&gt;",C2+">")));
        System.out.println("jkf".equals(null));
    }

    @Test
    public void time() {
        String timestr = "1626139241000";
        String timestr2 = "1626139241";
        System.out.println(new Date(Long.parseLong(timestr)));
        System.out.println(new Date(Long.parseLong(timestr2)));
        System.out.println("http2323/fsd/".endsWith("/"));
        System.out.println(Math.pow(2,2));
    }

    @Test
    public void maxString() {
        StringBuffer str = new StringBuffer();
        Long count = Double.valueOf(Math.pow(2, 31)).longValue() - 1;
        System.out.println(count);
        for (Long i = 1L; i<= count; i++){
            str.append("a");
        }
        log.info("str = {}",str);
    }

    @Test
    public void test05() {
        Map<String, String> map = new HashMap<>();
        map.put("abc","123");

        String str = null;
        log.info("{}",JSON.toJSONString(map.putIfAbsent("abc","456")));
        log.info("{}",JSON.toJSONString(map.putIfAbsent("ab","456")));
        log.info("{}",JSON.toJSONString(map));
        log.info("{}","123".equals(null));

        BigDecimal b1 = new BigDecimal("1.0");
        BigDecimal b2 = new BigDecimal(1);
        log.info("{}",b1.compareTo(b2) == 0);

    }

    @Test
    public void test001() {
        String content = "{casecenter}:{QUERYALL}:{管理员}:{查询嫌疑人}:{{\"isDeleted\":\"N\",\"leaveTimeEnd\":\"2021-09-17 23:59:59\",\"leaveTimeStart\":\"2021-09-17 00:00:00\",\"name\":\"<script>alert(0)</script>\",\"orgMagicId\":\"b0de29a062bd97362b208a966e99d8d1\",\"policeMagicId\":\"\"}}";
        String reg = "\\{(.*?)}";
        Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher(content);
        System.out.println(UserDto.class.getName());
        System.out.println(UserDto.class.getSimpleName());
        System.out.println(UserDto.class.getCanonicalName());
        System.out.println(UserDto.class.getTypeName());
    }

    @Test
    public void test09() {
        String str = "http://192.168.78.193:9090/default/video/dfeij/fefbn123";
        String ss = str.replaceAll("http://([\\w-]+\\.)+[\\w-]+:+[\\w+]+/default/video","/home/video");
        System.out.println(ss);
    }

    @Test
    public void test10() {
        System.out.println(Integer.valueOf(2)==null);
    }

    @Test
    public void test11() {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < 100000; i++) {
            String key = UUID.randomUUID().toString().replaceAll("-", "");
            int index = getIndex(key);
            Integer count = map.get(index);
            if (count == null) {
                map.put(index,1);
            }else {
                map.put(index,++count);
            }
//            log.info("key = {},index = {}",key, index);
        }
        log.info("===========:{}",JSON.toJSONString(map));
    }

    public int getIndex(String key){
        int count = 16;
        int hash = key.hashCode() ^ (key.hashCode() >>> 16);

        // 对hash值取模，将hash值路由到指定的内存队列中，比如内存队列大小8
        // 用内存队列的数量对hash值取模之后，结果一定是在0~7之间
        // 所以任何一个商品id都会被固定路由到同样的一个内存队列中去的
        int index = (count - 1) & hash;
        return index;
    }
}

