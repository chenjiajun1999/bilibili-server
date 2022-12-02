package com.bilibili.test;

import com.bilibili.common.thirdparty.MinioStore;
import com.bilibili.common.thirdparty.RedisCache;
import com.bilibili.util.RSAUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class UtilsTest {

    @Autowired
    MinioStore minioStore;

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
    void testRedis() {

        redisCache.setCacheObject("test", "demo");
        System.out.println(redisCache.getCacheObject("test").toString());
    }

    @Test
    void testMinio() throws Exception {

        List<String> strings = minioStore.getAllBucketsNames();
        strings.forEach(System.out::println);

    }

}
