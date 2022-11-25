package com.bilibili.test;


import com.bilibili.gatewayimpl.user.database.UserMapper;
import com.bilibili.gatewayimpl.user.database.dataobject.UserDO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;


    @Test
    void testInsert() {
        UserDO user = new UserDO();
        user.setPhone("13682962214");
        user.setEmail("1789573982@123.com");
        userMapper.insert(user);
        System.out.println(user.getId());
        assertThat(user.getId()).isNotNull();
    }
}