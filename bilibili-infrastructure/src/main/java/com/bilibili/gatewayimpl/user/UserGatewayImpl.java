package com.bilibili.gatewayimpl.user;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.bilibili.domain.user.User;
import com.bilibili.domain.user.gateway.UserGateway;
import com.bilibili.gatewayimpl.user.convertor.UserConvertor;
import com.bilibili.gatewayimpl.user.database.UserMapper;
import com.bilibili.gatewayimpl.user.database.dataobject.UserDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;


@Component
public class UserGatewayImpl implements UserGateway {

    @Autowired
    UserMapper userMapper;

    @Override
    public Boolean checkByPhone(String phone) {

        QueryWrapper<UserDO> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("phone", phone);
        return ObjectUtils.isNotEmpty(userMapper.selectOne(queryWrapper));
    }

    @Override
    public Boolean checkById(Long id) {
        QueryWrapper<UserDO> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", id);
        return ObjectUtils.isEmpty(userMapper.selectOne(queryWrapper));
    }

    @Override
    public void save(User user) {

        if (Objects.isNull(user.getId())) {
            register(user);
            return;
        }
        modify(user);

    }

    @Override
    public void register(User user) {
        userMapper.insert(UserConvertor.createUserDO(user));
    }

    @Override
    public void modify(User user) {

    }
}
