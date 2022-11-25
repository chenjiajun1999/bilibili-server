package com.bilibili.test;

import com.bilibili.utils.RSAUtils;
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

}
