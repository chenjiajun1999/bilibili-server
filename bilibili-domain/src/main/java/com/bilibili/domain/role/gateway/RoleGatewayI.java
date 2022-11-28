package com.bilibili.domain.role.gateway;

import java.util.List;

public interface RoleGatewayI {


    List<Long> getAuthElementOperationIdByRoleId(Long roleId);

    List<Long> getAuthMenuIdByRoleId(Long roleId);

    String getRoleNameById(Long roleId);

    String getRoleCodeById(Long roleId);

}
