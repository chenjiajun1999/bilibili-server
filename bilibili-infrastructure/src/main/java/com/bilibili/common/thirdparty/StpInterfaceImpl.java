package com.bilibili.common.thirdparty;

import cn.dev33.satoken.stp.StpInterface;
import cn.hutool.core.convert.Convert;
import com.bilibili.domain.auth.AuthMenu;
import com.bilibili.gatewayimpl.auth.AuthGatewayImpl;
import com.bilibili.gatewayimpl.role.RoleGatewayImpl;
import com.bilibili.gatewayimpl.user.UserGatewayImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 自定义权限验证接口扩展
 */
@Component
public class StpInterfaceImpl implements StpInterface {

    @Autowired
    UserGatewayImpl userGateway;

    @Autowired
    RoleGatewayImpl roleGateway;

    @Autowired
    AuthGatewayImpl authGateway;

    /**
     * 返回一个账号所拥有的权限码集合
     */
    @Override
    public List<String> getPermissionList(Object loginId, String loginType) {

        Long roleId = userGateway.getUserRoleIdById(Convert.toLong(loginId));
        List<Long> authMenuIdByRoleId = roleGateway.getAuthMenuIdByRoleId(roleId);
        List<Long> authElementOperationIdByRoleId = roleGateway.getAuthElementOperationIdByRoleId(roleId);

        List<String> list = new ArrayList<>();
        authMenuIdByRoleId.forEach(id->
                list.add(authGateway.getAuthMenuById(id).getCode()));
        authElementOperationIdByRoleId.forEach(id->
                list.add(authGateway.getAuthElementOperationById(id).getElementCode()));
        return list;
    }


    /**
     * 返回一个账号所拥有的角色标识集合 (权限与角色可分开校验)
     */
    @Override
    public List<String> getRoleList(Object loginId, String loginType) {

        Long roleId = userGateway.getUserRoleIdById(Convert.toLong(loginId));
        List<String> list = new ArrayList<>();
        list.add(roleGateway.getRoleCodeById(roleId));
        return list;
    }
}