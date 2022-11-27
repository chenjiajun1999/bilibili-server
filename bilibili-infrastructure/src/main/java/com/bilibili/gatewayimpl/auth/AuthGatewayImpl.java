package com.bilibili.gatewayimpl.auth;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bilibili.domain.auth.AuthElementOperation;
import com.bilibili.domain.auth.AuthMenu;
import com.bilibili.domain.auth.gateway.AuthGatewayI;
import com.bilibili.gatewayimpl.auth.convertor.AuthConvertor;
import com.bilibili.gatewayimpl.auth.database.AuthElementOperationMapper;
import com.bilibili.gatewayimpl.auth.database.AuthMenuMapper;
import com.bilibili.gatewayimpl.auth.database.dataobject.AuthElementOperationDO;
import com.bilibili.gatewayimpl.auth.database.dataobject.AuthMenuDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class AuthGatewayImpl implements AuthGatewayI {

    @Autowired
    AuthElementOperationMapper authElementOperationMapper;

    @Autowired
    AuthMenuMapper authMenuMapper;

    @Override
    public AuthElementOperation getAuthElementOperationById(Long elementOperationId) {

        QueryWrapper<AuthElementOperationDO> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", elementOperationId);
        return AuthConvertor.toEntity(authElementOperationMapper.selectOne(queryWrapper));
    }

    @Override
    public AuthMenu getAuthMenuById(Long menuId) {
        QueryWrapper<AuthMenuDO> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", menuId);
        return AuthConvertor.toEntity(authMenuMapper.selectOne(queryWrapper));
    }
}
