package io.sam;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;
import org.junit.Test;

import java.security.Key;

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
}
