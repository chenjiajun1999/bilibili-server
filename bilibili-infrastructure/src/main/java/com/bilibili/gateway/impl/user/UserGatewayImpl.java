package com.bilibili.gateway.impl.user;

import com.bilibili.domain.user.gateway.UserGateway;
import com.bilibili.gateway.impl.user.database.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class UserGatewayImpl implements UserGateway {

    @Autowired
    UserMapper userMapper;
}
