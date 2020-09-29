package io.sam;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;
import org.junit.Test;

import java.security.Key;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;
import java.util.UUID;

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
        System.out.println(UUID.randomUUID().toString().replace("-","").toUpperCase());
    }
}
