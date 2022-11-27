package com.bilibili.auth.executor;


import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.convert.Convert;
import com.alibaba.cola.dto.SingleResponse;
import com.bilibili.auth.assembler.AuthAssembler;
import com.bilibili.auth.dto.data.AuthDTO;
import com.bilibili.domain.auth.AuthElementOperation;
import com.bilibili.domain.auth.AuthMenu;
import com.bilibili.domain.auth.gateway.AuthGatewayI;
import com.bilibili.domain.role.gateway.RoleGatewayI;
import com.bilibili.domain.user.gateway.UserGatewayI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AuthGetCmdExe {

    @Autowired
    AuthGatewayI authGateway;

    @Autowired
    RoleGatewayI roleGateway;

    @Autowired
    UserGatewayI userGateway;

    public SingleResponse<AuthDTO> getAuth() {

        // 查询 roleId 对应的权限 id List
        Long roleId = userGateway.getUserRoleIdById(Convert.toLong(StpUtil.getLoginId()));
        List<Long> authElementOperationIdList = roleGateway.getAuthElementOperationIdByRoleId(roleId);
        List<Long> authMenuIdList = roleGateway.getAuthMenuIdByRoleId(roleId);

        List<AuthElementOperation> authElementOperationList = new ArrayList<>();
        List<AuthMenu> authMenuList = new ArrayList<>();
        authElementOperationIdList.forEach(id ->
                authElementOperationList.add(authGateway.getAuthElementOperationById(id)));
        authMenuIdList.forEach(id ->
                authMenuList.add(authGateway.getAuthMenuById(id)));

        return SingleResponse.of(AuthAssembler.toDataTransformObject(authElementOperationList, authMenuList));

    }
}
