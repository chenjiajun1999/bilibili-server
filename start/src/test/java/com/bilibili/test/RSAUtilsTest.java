package com.bilibili.test;

import com.bilibili.common.utils.TokenUtils;
import com.bilibili.utils.RSAUtils;
import jdk.nashorn.internal.parser.Token;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RSAUtilsTest {

    @Test
    void testRSA() {

        String encoder = RSAUtils.encrypt("123456");
        String decoder = RSAUtils.decrypt(encoder);
        System.out.println(encoder);
        System.out.println(decoder);

    }

    @Test
    void testJWT() {

        String jwt = TokenUtils.generateToken((long) 111);
        System.out.println(TokenUtils.verifyToken(jwt));

    }

}
