package io.sam;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;
import org.junit.Test;

import java.security.Key;
import java.text.MessageFormat;

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
        System.out.println(MessageFormat.format(CONDITION,"abc",123));
        System.out.println(String.format(CONDITION2,"abc",123));
    }
}
