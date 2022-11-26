package com.bilibili.test;

import com.bilibili.common.cache.RedisCache;
import com.bilibili.common.util.TokenUtil;
import com.bilibili.util.RSAUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UtilsTest {


    @Autowired
    RedisCache redisCache;

    @Test
    void testRSA() {

        String encoder = RSAUtil.encrypt("123456");
        String decoder = RSAUtil.decrypt(encoder);
        System.out.println(encoder);
        System.out.println(decoder);

    }

    @Test
    void testJWT() {

        String jwt = TokenUtil.generateToken((long) 111);
        System.out.println(TokenUtil.verifyToken(jwt));

    }

    @Test
    void testRedis() {

        redisCache.setCacheObject("test", "demo");
        System.out.println(redisCache.getCacheObject("test").toString());
    }

}
